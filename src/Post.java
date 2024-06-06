import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Post {
    private int postId;
    private String postTitle;
    private String postBody;
    private String[] postTags;
    private String[] postTypes = { "Very Difficult", "Difficult", "Easy" };
    private String[] postEmergency = { "Immediately needed", "Highly Needed", "Ordinary" };
    private ArrayList<String> postComments = new ArrayList<>();

    // getters
    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public String[] getPostTags() {
        return postTags;
    }

    public String[] getpostTypes() {
        return postTypes;
    }

    public String[] getPostEmergency() {
        return postEmergency;
    }

    public ArrayList<String> getComments() {
        return postComments;
    }

    // setters
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public void setPostTags(String[] postTags) {
        this.postTags = postTags;
    }

    public void setPostTypes(String[] postTypes) {
        this.postTypes = postTypes;
    }

    public void setPostEmergency(String[] postEmergency) {
        this.postEmergency = postEmergency;
    }

    public void setComments(ArrayList<String> postComments) {
        this.postComments = postComments;
    }

    public boolean addPost() {
        // Title Conditions
        if (postTitle.length() < 10 || postTitle.length() > 250) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (!Character.isLetter(postTitle.charAt(i))) {
                return false;
            }
        }

        // Body Conditions
        if (postBody.length() < 250) {
            return false;
        }

        // Tags Conditions
        if (postTags.length < 2 || postTags.length > 5) {
            return false;
        }
        for (String tag : postTags) {
            if (tag.length() < 2 || tag.length() > 10 || tag.matches(".*[A-Z].*")) {
                return false;
            }
        }

        // Post Type Conditions
        if (postTypes[0].equals("Easy") && postTags.length > 3) {
            return false;
        }
        if ((postTypes[0].equals("Difficult") || postTypes[0].equals("Very Difficult")) && postBody.length() < 300) {
            return false;
        }

        // Post Emergency Status Conditions
        if (postTypes[0].equals("Easy")
                && (postEmergency[0].equals("Immediately Needed") || postEmergency[0].equals("Highly Needed"))) {
            return false;
        }
        if ((postTypes[0].equals("Very Difficult") || postTypes[0].equals("Difficult"))
                && postEmergency[0].equals("Ordinary")) {
            return false;
        }

        // Writing Post
        try (FileWriter postFile = new FileWriter("posts.txt", true)) {
            postFile.write("Post ID: " + postId + "\n");
            postFile.write("Title: " + postTitle + "\n");
            postFile.write("Body: " + postBody + "\n");
            postFile.write("Tags: " + String.join(", ", postTags) + "\n");
            postFile.write("Type: " + postTypes + "\n");
            postFile.write("Emergency: " + postEmergency + "\n");
            postFile.write("Comments: " + String.join(", ", postComments) + "\n");
            postFile.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addComment(String commentText) {
        // Condition 1
        String[] words = commentText.split(" ");
        if ((words.length < 4 || words.length > 10)) {
            return false;
        }
        if (!Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }
        // Condition 2
        if (postComments.size() == 5) {
            return false;
        }

        if (((postTypes[0].equals("Easy") || postEmergency[0].equals("Ordinary")) && postComments.size() == 3)) {
            return false;
        }
        postComments.add(commentText);

        // Writing Comment
        try (FileWriter commentFile = new FileWriter("comments.txt", true)) {
            commentFile.write("Post ID: " + postId + "\n");
            commentFile.write("Comment: " + commentText + "\n");
            commentFile.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
