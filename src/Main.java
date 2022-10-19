import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            // обработка разных случаев

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя

            if (userInput == 1) { //Ввод кол-ва шагов за день
                System.out.println("Укажите номер месяца (начиная с 0 до 11)");
                int month = scanner.nextInt(); //
                System.out.println("Укажите день (начиная с 0 до 29)");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                tracker.inputSteps(month, day, steps);

            } else if (userInput == 2) { //Статистика

                System.out.println("Введите номер месяца (начиная с 0)");
                int month = scanner.nextInt();
                tracker.outputSteps(month); //Кол-во шагов по дням
                tracker.getAllSteps(month); //Пройдено всего за месяц
                tracker.getDayWithMaxSteps(month); // Максимум пройдено за день
                tracker.getTheMeanSteps(month); //Среднее число шагов в день
                tracker.calcCalories(month); //Потрачено килокалорий
                tracker.calcDistance(month); //Пройдено километров
                tracker.getBestSeries(month); // Лучшая серия выполненной цели

            } else if (userInput == 3) { //Новая цель по шагам
                System.out.println("Текущая цель - " + StepTracker.returnTarget() + " шагов в день.");
                System.out.println("Какой будет ваша новая цель?");
                int newTarget = scanner.nextInt();
                tracker.changeTarget(newTarget);
                System.out.println("Теперь ваша цель - " + newTarget + " шагов.");

            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }


    }

}
    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}
