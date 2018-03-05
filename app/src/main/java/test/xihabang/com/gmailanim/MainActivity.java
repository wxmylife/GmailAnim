package test.xihabang.com.gmailanim;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import test.xihabang.com.gmailanim.adapter.MessagesAdapter;
import test.xihabang.com.gmailanim.data.DataRepertory;
import test.xihabang.com.gmailanim.helper.DividerItemDecoration;
import test.xihabang.com.gmailanim.model.Message;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, MessagesAdapter.MessageAdapterListener {

  private List<Message> messages = new ArrayList<>();

  private RecyclerView recyclerView;

  private SwipeRefreshLayout swipeRefreshLayout;

  private MessagesAdapter mAdapter;

  private ActionMode actionMode;

  private ActionModeCallback actionModeCallback;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
    swipeRefreshLayout.setOnRefreshListener(this);

    mAdapter = new MessagesAdapter(this,messages, this);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    recyclerView.setAdapter(mAdapter);

    actionModeCallback = new ActionModeCallback();

    swipeRefreshLayout.post(
        new Runnable() {
          @Override
          public void run() {
            getInboxData();
          }
        }
    );
  }


  @Override public void onRefresh() {
    getInboxData();
  }


  private void getInboxData() {
    swipeRefreshLayout.setRefreshing(true);
    recyclerView.postDelayed(new Runnable() {
      @Override public void run() {
        messages.clear();
        for (Message message : DataRepertory.getData()) {
          // generate a random color
          message.setColor(getRandomMaterialColor("400"));
          messages.add(message);
        }
        mAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
      }
    }, 1500);
  }

  /**
   * chooses a random color from array.xml
   */
  private int getRandomMaterialColor(String typeColor) {
    int returnColor = Color.GRAY;
    int arrayId = getResources().getIdentifier("mdcolor_" + typeColor, "array", getPackageName());

    if (arrayId != 0) {
      TypedArray colors = getResources().obtainTypedArray(arrayId);
      int index = (int) (Math.random() * colors.length());
      returnColor = colors.getColor(index, Color.GRAY);
      colors.recycle();
    }
    return returnColor;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_search) {
      Toast.makeText(getApplicationContext(), "Search...", Toast.LENGTH_SHORT).show();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }


  @Override
  public void onIconClick(int position) {
    if (actionMode == null) {
      actionMode = startSupportActionMode(actionModeCallback);
    }

    toggleSelection(position);
  }

  @Override
  public void onIconImportantClicked(int position) {
    // Star icon is clicked,
    // mark the message as important
    Message message = messages.get(position);
    message.setImportant(!message.isImportant());
    messages.set(position, message);
    mAdapter.notifyDataSetChanged();
  }

  @Override
  public void onMessageRowClicked(int position) {
    // verify whether action mode is enabled or not
    // if enabled, change the row state to activated
    if (mAdapter.getSelectedItemCount() > 0) {
      enableActionMode(position);
    } else {
      // read the message which removes bold from the row
      Message message = messages.get(position);
      message.setRead(true);
      messages.set(position, message);
      mAdapter.notifyDataSetChanged();

      Toast.makeText(getApplicationContext(), "Read: " + message.getMessage(), Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onRowLongClicked(int position) {
    // long press is performed, enable action mode
    enableActionMode(position);
  }

  private void enableActionMode(int position) {
    if (actionMode == null) {
      actionMode = startSupportActionMode(actionModeCallback);
    }
    toggleSelection(position);
  }

  private void toggleSelection(int position) {
    mAdapter.toggleSelection(position);
    int count = mAdapter.getSelectedItemCount();

    if (count == 0) {
      actionMode.finish();
    } else {
      actionMode.setTitle(String.valueOf(count));
      actionMode.invalidate();
    }
  }


  private class ActionModeCallback implements ActionMode.Callback {
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
      mode.getMenuInflater().inflate(R.menu.menu_action_mode, menu);

      // disable swipe refresh if action mode is enabled
      swipeRefreshLayout.setEnabled(false);
      return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
      return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
      switch (item.getItemId()) {
        case R.id.action_delete:
          // delete all the selected messages
          deleteMessages();
          mode.finish();
          return true;

        default:
          return false;
      }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
      mAdapter.clearSelections();
      swipeRefreshLayout.setEnabled(true);
      actionMode = null;
      recyclerView.post(new Runnable() {
        @Override
        public void run() {
          mAdapter.resetAnimationIndex();
          // mAdapter.notifyDataSetChanged();
        }
      });
    }
  }

  // deleting the messages from recycler view
  private void deleteMessages() {
    mAdapter.resetAnimationIndex();
    List<Integer> selectedItemPositions =
        mAdapter.getSelectedItems();
    for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
      mAdapter.removeData(selectedItemPositions.get(i));
    }
    mAdapter.notifyDataSetChanged();
  }
}