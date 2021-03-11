package edu.qc.seclass.parstagram.fragments;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import edu.qc.seclass.parstagram.Post;

public class ProfileFragment extends PostsFragment {

    @Override
    protected void queryPosts() {
        super.queryPosts();
        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        // includes author information
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_AT);
        // queries for all posts
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issues with getting posts", e);
                    return;
                } else {
                    for (Post post: posts) {
                        Log.i(TAG, "Posts: " + post.getDescription() + ", user is: " + post.getUser().getUsername());
                    }
                    allPosts.addAll(posts);
                    // notify adapter that data set has changed
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
