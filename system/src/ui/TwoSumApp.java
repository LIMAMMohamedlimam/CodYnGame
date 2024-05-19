package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TwoSumApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Topsection: Problem description
        Label titleLabel = new Label("1. Two Sum");
        titleLabel.setFont(new Font(20));
        TextArea descriptionArea = new TextArea(
                "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n\n" +
                        "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n\n" +
                        "You can return the answer in any order.\n\n" +
                        "Example 1:\nInput: nums = [2,7,11,15], target = 9\nOutput: [0,1]\nExplanation: Because nums[0] + nums[1] == 9, we return [0, 1].\n\n" +
                        "Example 2:\nInput: nums = [3,2,4], target = 6\nOutput: [1,2]\n\n" +
                        "Example 3:\nInput: nums = [3,3], target = 6\nOutput: [0,1]\n\n" +
                        "Constraints:\n- 2 <= nums.length <= 10^4\n- -10^9 <= nums[i] <= 10^9\n- -10^9 <= target <= 10^9\n- Only one valid answer exists.\n\n" +
                        "Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?"
        );
        descriptionArea.setWrapText(true);
        descriptionArea.setEditable(false);
        descriptionArea.setPrefHeight(300);

        VBox topSection = new VBox(10, titleLabel, descriptionArea);
        topSection.setPadding(new Insets(10));
        mainLayout.setTop(topSection);

        // Center section: Code editor
        Label codeLabel = new Label("Code:");
        TextArea codeArea = new TextArea(
                "class Solution {\n" +
                        "    public int[] twoSum(int[] nums, int target) {\n" +
                        "        Map<Integer, Integer> numMap = new HashMap<>();\n" +
                        "        for (int i = 0; i < nums.length; i++) {\n" +
                        "            int complement = target - nums[i];\n" +
                        "            if (numMap.containsKey(complement)) {\n" +
                        "                return new int[] { numMap.get(complement), i };\n" +
                        "            }\n" +
                        "            numMap.put(nums[i], i);\n" +
                        "        }\n" +
                        "        throw new IllegalArgumentException(\"No two sum solution\");\n" +
                        "    }\n" +
                        "}"
        );
        codeArea.setWrapText(true);
        codeArea.setPrefHeight(300);

        VBox centerSection = new VBox(10, codeLabel, codeArea);
        centerSection.setPadding(new Insets(10));
        mainLayout.setCenter(centerSection);

        // Bottom section: Test cases
        Label testLabel = new Label("Testcase");
        TextArea testArea = new TextArea(
                "Case 1\nnums = [2,7,11,15]\ntarget = 9\n\n" +
                        "Case 2\nnums = [3,2,4]\ntarget = 6\n\n" +
                        "Case 3\nnums = [3,3]\ntarget = 6"
        );
        testArea.setWrapText(true);
        testArea.setPrefHeight(150);

        VBox bottomSection = new VBox(10, testLabel, testArea);
        bottomSection.setPadding(new Insets(10));
        mainLayout.setBottom(bottomSection);

        // Scene and stage setup
        Scene scene = new Scene(mainLayout, 800, 800);
        primaryStage.setTitle("Two Sum Problem");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
