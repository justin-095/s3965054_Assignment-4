import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class addCommentTest {
    @Test
    /*
     * length >= 4 && length <= 10
     */
    void checkCommentWords() {
        Post post = new Post();
        assertFalse(post.addComment("Bro"));
    }

    @Test
    /*
     * First letter should be an uppercase letter
     */
    void checkUpperCase() {
        Post post = new Post();
        assertFalse(post.addComment("how are you? what are you?"));
    }

    @Test
    /*
     * Multiple comments added in posts
     */
    void checkCommentQuantity() {
        Post post = new Post();
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
    }

    @Test
    /*
     * Each post should have max 5 comments
     */
    void checkCommentLength() {
        Post post = new Post();
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertFalse(post.addComment("How are you? what are you?"));
    }

    @Test
    /*
     * Condition Post Emergency: Posts that are "Easy" or "Ordinary" should have a
     * max of 3 comments
     */
    void checkEasy_OrdinaryComments() {
        String[] postType = { "Easy" };
        String[] postEmergency = { "Ordinary" };
        Post post = new Post();
        post.setPostTypes(postType);
        post.setPostEmergency(postEmergency);
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertTrue(post.addComment("How are you? what are you?"));
        assertFalse(post.addComment("How are you? what are you?"));
    }

    @Test
    /*
     * Condition Comment Length: Comment is greater than 10
     */
    void checkComment() {
        Post post = new Post();
        assertFalse(post.addComment(
                "How are you? what are you? How are you? what are you? How are you? what are you? How are you? what are you?"));
    }

}