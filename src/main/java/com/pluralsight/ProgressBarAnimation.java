package com.pluralsight;

public class ProgressBarAnimation {
    public static void main(String[] args) throws InterruptedException {
        // Total number of steps in the progress bar
        int totalSteps = 10;

        // Time interval between updates in animation
        int loadTime = 200;

        // Looping through each step for updating animation
        for (int step = 0; step <= totalSteps; step++) {

            // Calculating the completion percentage to display according to updated animation
            int completion = (step * 100) / totalSteps;

            // Creating String alongside the completion percentage
            String progressBar = createProgressBar(completion);

            // Updating function to display the animation
            updateProgressBar(progressBar);

            // Pausing to simulate the animation
            Thread.sleep(loadTime);
        }
    }

    // Creating a method to calculate the percentage in accordance to updated bar
    public static String createProgressBar(int completion) {
        // Length of progress bar and calculation for completion percentage
        int barLength = 20;
        int completedBars = (completion * barLength) / 100;

        // Creating progressbar by repeating the completed bars on top of pre-determined length of uncompleted bars
        return "█".repeat(completedBars) +
                "▒".repeat(barLength - completedBars) +
                " " + completion + "%";
    }

    public static void updateProgressBar(String progressBar) {
        // Utilizing carriage return to overwrite on the same line
        // with every updated bar
        System.out.print("\r" + progressBar);
    }
}
