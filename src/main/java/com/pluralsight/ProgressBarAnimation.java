package com.pluralsight;

public class ProgressBarAnimation {
//    public static void main(String[] args) throws InterruptedException {
//        int totalSteps = 10;
//        int loadTime = 200;
//
//        for (int step = 0; step <= totalSteps; step++) {
//            int completion = (step * 100) / totalSteps;
//            String progressBar = createProgressBar(completion);
//            updateProgressBar(progressBar);
//            Thread.sleep(loadTime);
//        }
//    }
//
//    public static String createProgressBar(int completion) {
//        int barLength = 20;
//        int completedBars = (completion * barLength) / 100;
//
//        StringBuilder progressBar = new StringBuilder();
//        progressBar.append("█".repeat(completedBars));
//        progressBar.append("▒".repeat(barLength - completedBars));
//        progressBar.append(" ").append(completion).append("%");
//
//        return progressBar.toString();
//
//    }
//    public static void updateProgressBar(String progressBar) {
//        System.out.print("\r" + progressBar);
//    }
}
