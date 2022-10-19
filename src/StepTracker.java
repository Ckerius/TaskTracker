public class StepTracker {


    static int target = 10000;
     MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public static int returnTarget() {
        return target;
    }
    public void inputSteps(int month, int day, int steps) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.setSteps(day, steps);
    }
    public void outputSteps(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.getSteps();
    }
    public void getAllSteps(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.getAllSteps();
    }
    public void getDayWithMaxSteps(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.getMax();
    }
    public  void getTheMeanSteps(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.getTheMean();
    }
    public void calcCalories(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.calories();
    }
    public void calcDistance(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.distance();
    }
    public  void getBestSeries(int month) {
        MonthData monthToDataId = monthToData[month];
        monthToDataId.series();
    }
    public void changeTarget(int newTarget) {
        if (newTarget >= 0) {
            target = newTarget;
        } else {
            System.out.println("Ошибка: отрицательное число");
        }
    }

}
class MonthData {
    int[] daySteps = new int[30];

    void setSteps(int day, int steps) {
        daySteps[day] = steps;
    }
     public void getSteps() {
        for (int i = 0; i < daySteps.length; i++) {
           System.out.print((i + 1) + " день: " + daySteps[i] + ", ");
        } System.out.println();

    }
    public void getAllSteps() {
        int result = 0;
        for (int i: daySteps) {
            result = result + i;
        }
        System.out.println("Всего за месяц было пройдено " + result + " шагов.");
    }
    public void getMax() {
        int max = 0;
        for (int i = 0; i < daySteps.length; i++) {
            if (max < daySteps[i]){
                max = daySteps[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов - " + max + ".");
    }
    public void getTheMean() {
        int sum = 0;
        for (int i = 0; i < daySteps.length; i++) {
            sum = sum + daySteps[i];
        }
        int result = sum / daySteps.length;
        System.out.println("В среднем за месяц вы прошли " + result + " шагов в день.");
    }
    public void calories() {
        int stepsSum = 0;
        for (int i = 0; i < daySteps.length; i++) {
            stepsSum = stepsSum + daySteps[i];
        }
        System.out.println("Всего потрачено " + Converter.calories(stepsSum) + " ккал.");
    }
    public void distance() {
        int stepsSum = 0;
        for (int i = 0; i < daySteps.length; i++) {
            stepsSum = stepsSum + daySteps[i];
        }
        System.out.println("Всего пройдено " + Converter.distance(stepsSum) + " км.");
    }
    public void series() {
        int currentSeries = 0;
        int bestSeries = 0;
        int target = StepTracker.returnTarget();
        for (int i = 0; i < daySteps.length; i++) {
            if (daySteps[i] >= target) {
                currentSeries = currentSeries + 1;
            } else {
                if (bestSeries <= currentSeries) {
                    bestSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        System.out.println("Лучшая серия за месяц - " + bestSeries + " дней в цели.");
    }
}
