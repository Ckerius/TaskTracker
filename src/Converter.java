public class Converter {
    public static int calories(int steps) {
        int kcal = steps * 5 / 100;
        return kcal;
    }
    public static double distance(int steps) {
        double km = steps * 0.75 / 1000;
        return km;
    }
}

/*
В этом классе осуществляется преобразование шагов в километры и калории.
    Для подсчёта дистанции можно считать, что один шаг равен 75 см.
    Для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
 */