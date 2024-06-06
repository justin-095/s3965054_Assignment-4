import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class addPostTest {
    @Test
    void testTitle() {
        /*
         * Title Conditions: < 10 length
         */
        String[] tags = { "tag1", "tag2" };
        String[] type = { "Difficult" };
        String[] postEmergency = { "Highly Needed" };
        Post post = new Post();
        post.setPostId(1);
        post.setPostTitle("The");
        post.setPostBody(
                "This is a sample Lorem IpcheckTitleLength\n" + //
                        "checkTitleLength\n" + //
                        "checkTitleLength\n" + //
                        "checkTitleLength\n" + //
                        "checkTitleLength\n" + //
                        "checkTitleLength\n" + //
                        "checkTitleLength\n" + //
                        "checkTitleLengthsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);

        assertFalse(post.addPost());
    }

    @Test
    void testTitleSpecialCharacter() {
        /*
         * Title Conditions: first five characters contains non aplhabetic character
         */
        String[] tags = { "tag1", "tag2" };
        String[] type = { "Difficult" };
        String[] postEmergency = { "Highly Needed" };
        Post post = new Post();
        post.setPostId(2);
        post.setPostTitle("!@#Empowering AI Innovations");
        post.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);

        assertFalse(post.addPost());
    }

    @Test
    void checkPostBody() {
        /*
         * Body Conditions: < 250 characters
         */

        String[] tags = { "tag1", "tag2" };
        String[] type = { "Difficult" };
        String[] postEmergency = { "Highly Needed" };
        Post checkBody = new Post();
        checkBody.setPostId(3);
        checkBody.setPostTitle("Empowering AI Innovations");
        checkBody.setPostBody("his is a sample Lorem Ipsum text segment");
        checkBody.setPostTags(tags);
        checkBody.setPostTypes(type);
        checkBody.setPostEmergency(postEmergency);

        assertFalse(checkBody.addPost());
    }

    @Test
    void checkTagsAmount() {
        /*
         * Tags Conditions: < 2 Tags
         */

        String[] tags = { "tag1" };
        String[] type = { "Difficult" };
        String[] postEmergency = { "Highly Needed" };
        Post checkTags = new Post();
        checkTags.setPostId(4);
        checkTags.setPostTitle("Empowering AI Innovations");
        checkTags.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        checkTags.setPostTags(tags);
        checkTags.setPostTypes(type);
        checkTags.setPostEmergency(postEmergency);

        assertFalse(checkTags.addPost());
    }

    @Test
    /*
     * Tags Conditions: < uppercase in Tag
     */
    void checkTagsExtraCondition() {
        String[] tags = { "tag1", "Tag2" };
        String[] type = { "Difficult" };
        String[] postEmergency = { "Highly Needed" };
        Post post = new Post();
        post.setPostId(5);
        post.setPostTitle("Empowering AI Innovations");
        post.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);

        assertFalse(post.addPost());

    }

    @Test
    /*
     * Tags Condition: "Easy" posts should not have more than 3 tags
     */
    void checkingEasyPostType() {
        String[] tags = { "tag1", "tag2", "tag3", "tag4", "tag5" };
        String[] type = { "Easy" };
        String[] postEmergency = { "Ordinary" };
        Post post = new Post();
        post.setPostId(6);
        post.setPostTitle("Empowering AI Innovations");
        post.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);

        assertFalse(post.addPost());

    }

    @Test
    /*
     * Tags Condition: "Very Difficult" & "Difficult" posts should have a minimum of
     * 300 characters
     * in body.
     */
    void checkOtherPostType() {
        String[] tags = { "tag1", "tag2" };
        String[] type = { "Difficult" };
        String[] postEmergency = { "Immediately Needed", "Highly Needed" };
        Post post = new Post();
        post.setPostId(8);
        post.setPostTitle("Empowering AI Innovations");
        post.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);
        assertTrue(post.addPost());

    }

    @Test
    /*
     * Post Emergency Condition: "Easy" post Type should NOT have
     * "Immediately Needed" & "Highly Needed" status
     */
    void checkEasyEmergency() {
        String[] tags = { "tag1", "tag2" };
        String[] type = { "Easy" };
        String[] postEmergency = { "Immediately Needed", "Highly Needed" };
        Post post = new Post();
        post.setPostId(8);
        post.setPostTitle("Empowering AI Innovations");
        post.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);
        assertFalse(post.addPost());
    }

    @Test
    /*
     * Post Emergency Condition: Very
     * Difficult" & "Difficult" posts should not have "Ordinary" status
     */
    void CheckOtherEmergency() {
        String[] tags = { "tag1", "tag2" };
        String[] type = { "Difficult", "Very Difficult" };
        String[] postEmergency = { "Ordinary" };
        Post post = new Post();
        post.setPostId(9);
        post.setPostTitle("Empowering AI Innovations");
        post.setPostBody(
                "This is a sample Lorem Ipsum text segment. It is designed to be approximately 75 characters long. "
                        + "Lorem Ipsum is simply dummy text of the printing and typesetting industry. It has been the industry's "
                        + "standard dummy text ever since the 1500s. When an unknown printer took a galley of type and scrambled "
                        + "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic "
                        + "typesetting, remaining essentially unchanged.");
        post.setPostTags(tags);
        post.setPostTypes(type);
        post.setPostEmergency(postEmergency);

        assertFalse(post.addPost());
    }
}