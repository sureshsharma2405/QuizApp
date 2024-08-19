import java.util.*;

public class QuizApp {
    private static String[] questions = {
            "What is the capital of France?",
            "What is 2 + 2?",
            "What is the capital of Japan?"
    };

    private static String[][] options = {
            {"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
            {"1. 3", "2. 4", "3. 5", "4. 6"},
            {"1. Beijing", "2. Tokyo", "3. Seoul", "4. Bangkok"}
    };

    private static int[] answers = {3, 2, 2}; // Correct answers (index of options)

    private static int score = 0;
    private static int currentQuestion = 0;
    private static boolean answered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        for (int i = 0; i < questions.length; i++) {
            currentQuestion = i;
            answered = false;

            System.out.println(questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (!answered) {
                        System.out.println("Time's up!");
                        nextQuestion();
                    }
                }
            }, 10000); // 10 seconds timer

            int userAnswer = scanner.nextInt();
            answered = true;

            if (userAnswer == answers[i]) {
                score++;
            }

            nextQuestion();
        }

        System.out.println("Quiz over! Your score is: " + score);
        scanner.close();
        timer.cancel();
    }

    private static void nextQuestion() {
        if (currentQuestion < questions.length - 1) {
            System.out.println("Next question...");
        }
    }
}

