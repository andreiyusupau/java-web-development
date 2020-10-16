package com.andreiyusupau.tetrahedron.service;

import com.andreiyusupau.tetrahedron.model.Point;

//Part 1
//        +Разработать entity-классы, например: «Разработать классы Точка и Круг»➢Entity-классыне следует наполнять методами,
//        выполняющими функциональные действия (методами бизнес-логики, такими как вычисление, поиски т.д.).
//      + ➢Разработать классылогики реализующие заданные функциональности, например:
//        «Реализовать методы вычисления площади и периметра круга»➢Параметры, необходимые для создания объектов,
//       - организовать как чтение информациииз файла (.txt).Часть данных должны некорректной.
//        Если встретилась некорректная строка, приложение должно переходить к следующей строке.
//        Все файлы должны находиться в отдельном каталоге.
//       -➢Разработать классы для валидацииисходныхданных для создания
//        объектов entity-классов.Например: корректнаястрока в файле для создания объекта Круг:«1.0 2.0 3.0»,где первое
//        число задает радиус круга, второе и третье –координаты центра;некорректнаястрока в файле для создания объекта
//        Круг:«1.z0 2.0 3.0»-недопустимый символ«z», всю строку следует считать некорректной здесь и в случаях приведенных
//        ниже;некорректнаястрока в файле для создания объекта Круг:«1.0 2.0»-недостаточно информации для создания объекта;
//        некорректнаястрока в файле для создания объекта Круг:«-1.0 2.0 3.0»-невозможно создать Круг с отрицательным радиусом.
//      +  ➢Для классов-сущностей следуетпереопределять методы класса Object: toString(), equals(), hashCode().
//        Методы класса Objects не использовать.
//       + ➢Все классыприложения должны быть структурированы по пакетам.
//       - ➢Использовать собственные классы исключительных ситуаций.
//       +➢Оформление кодадолжно соответствовать JavaCodeConvention.
//        -➢Для записи логов использовать Log4J2.
//        +➢Код должен быть покрыт Unit-тестами.Принаписании тестовзапрещено:
//        писать логи и использовать операторы ветвления:if, for, while, do\while, switch;
//        +➢Класс с методом main в задании должен отсутствовать.Запуск только тестами.
//        ➢Обратить внимание на примечания1 и 2
//        Тетраэдр.Разработать классы Точка и Тетраэдр. Создатьметоды итесты:вычисления площади поверхности фигуры и ее объема,
//        а также соотношения объемов получаемых в результате рассечения фигуры координатной плоскостью;является ли объект заданной фигурой;
//       - находится ли основание фигурына одной из координатных плоскостей.
//Part 2
//Площади, Объемы,Периметры фигур должны храниться в объекте класса-регистратора.
//        ➢Любое изменение параметра фигуры должно вызывать пересчет соответствующих значений в классе-регистраторе.
//        Для решения данной задачи использовать паттерныObserver(можно использовать FlowAPI)и
//        Singleton(потокобезопасные варианты использовать запрещено).
//        ➢Все созданные объекты геометрических фигур сохранить в объекте-репозитории.
//        ➢Используя  шаблон   Repository,  разработать  спецификации  по  добавлению,
//        удалению  и изменению объектов репозитория.➢Разработать спецификации по поиску объектов и групп объектов в репозитории.
//        По ID,по имени,покоординатам (например: найти все объекты точки которых находятся в первом квадранте,
//        найти  все  объекты  площади  поверхности  (объемы,  периметры)  которых заключены в заданный диапазон,
//        найти объекты находящиеся на расстоянии в заданном диапазоне от начала координат)
//        ➢Разработать методы сортировки наборов объектов по ID,по имени,по координатам Х первой точки,
//        по координатам Yпервой точкии т д. Использовать интерфейс Comparator.

public class GeometryService {

    private Point calculateVector(Point a, Point b) {
        double x = b.getX() - a.getX();
        double y = b.getY() - a.getY();
        double z = b.getZ() - a.getZ();
        return new Point(x, y, z);
    }

    private Point calculateCrossProduct(Point a, Point b) {
        double x = a.getY() * b.getZ() - a.getZ() * b.getY();
        double y = a.getZ() * b.getX() - a.getX() * b.getZ();
        double z = a.getX() * b.getY() - a.getY() * b.getX();
        return new Point(x, y, z);
    }

    private double calculateVectorModule(Point a) {
        return Math.sqrt(Math.pow(a.getX(), 2) + Math.pow(a.getY(), 2) + Math.pow(a.getZ(), 2));
    }

    private double calculateTriangleArea(Point a, Point b, Point c) {
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        Point vectorCrossProduct = calculateCrossProduct(vectorAB, vectorAC);
        double vectorModule = calculateVectorModule(vectorCrossProduct);
        return 0.5 * vectorModule;
    }

    public double calculateTetrahedronArea(Point a, Point b, Point c, Point d) {
        double abcArea = calculateTriangleArea(a, b, c);
        double bcdArea = calculateTriangleArea(b, c, d);
        double cdaArea = calculateTriangleArea(c, d, a);
        double dabArea = calculateTriangleArea(d, a, b);
        return abcArea + bcdArea + cdaArea + dabArea;
    }

    private double calculateTripleProduct(Point row1, Point row2, Point row3) {
        return row1.getX() * row2.getY() * row3.getZ() +
                row1.getZ() * row2.getX() * row3.getY() +
                row1.getY() * row2.getZ() * row3.getX() -
                row1.getZ() * row2.getY() * row3.getX() -
                row1.getX() * row2.getZ() * row3.getY() -
                row1.getY() * row2.getX() * row3.getZ();
    }

    public double calculateTetrahedronVolume(Point a, Point b, Point c, Point d) {
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        Point vectorAD = calculateVector(a, d);
        double tripleProduct = calculateTripleProduct(vectorAB, vectorAC, vectorAD);
        return Math.abs(tripleProduct) / 6;
    }

    private double dotProduct(Point a, Point b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    private Point scale(Point a, double scale) {
        double x = a.getX() * scale;
        double y = a.getY() * scale;
        double z = a.getZ() * scale;
        return new Point(x, y, z);
    }

    private Point sum(Point a, Point b) {
        double x = a.getX() + b.getX();
        double y = a.getY() + b.getY();
        double z = a.getZ() + b.getZ();
        return new Point(x, y, z);
    }

    private Point calculateIntersectionPointOfPlaneAndLine(Point a, Point b, Point c, Point x, Point y) {
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        // N = VP ( B - A, C - A )
        Point vectorCrossProduct = calculateCrossProduct(vectorAB, vectorAC);
        //TODO:normal vector direction
        // N = N / | N |  - нормаль к плоскости
//V = A - X
        Point vectorAD = calculateVector(a, x);
        // расстояние до плоскости по нормали
        //  d = SP ( N, V )
        double d = -dotProduct(vectorCrossProduct, vectorAD); //знак?
        if (compareDouble(d, 0)) {

        }
        //   W = Y - X
        Point vectorDE = calculateVector(x, y);
// приближение к плоскости по нормали при прохождении отрезка
        // e = SP ( N, W )
        double e = dotProduct(vectorCrossProduct, vectorDE);
        if (!compareDouble(e, 0)) {
            //  O = X + W * d/e;          // одна точка
            double sI = d / e;
            Point scaledDE = scale(vectorDE, sI);
            return sum(x, scaledDE);
        } else {
            return null;
        }
    }

    /**
     * Calculates the volume ratio of two parts of tetrahedron divided by plane
     *
     * @param a tetrahedron point A
     * @param b tetrahedron point B
     * @param c tetrahedron point C
     * @param d tetrahedron point D
     * @param e plane point E
     * @param f plane point F
     * @param g plane point G
     * @return partVolume/full volume
     */
    public double calculateVolumeRatioAfterThePlaneSection(Point a, Point b, Point c, Point d, Point e, Point f, Point g) {
        Point abi = calculateIntersectionPointOfPlaneAndLine(e, f, g, a, b);
        Point aci = calculateIntersectionPointOfPlaneAndLine(e, f, g, a, c);
        Point adi = calculateIntersectionPointOfPlaneAndLine(e, f, g, a, d);
        double fullVolume = calculateTetrahedronVolume(a, b, c, d);
        if (abi != null && aci != null && adi != null) {
            double partVolume = calculateTetrahedronVolume(a, abi, aci, adi);
            return partVolume / (fullVolume - partVolume);
        } else if (abi == null && aci == null && adi == null) {
            return 0;
        } else if (aci == null && adi == null) {
            Point bci = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, c);
            Point bdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, d);
            double partVolume = calculateTetrahedronVolume(b, abi, bci, bdi);
            return partVolume / (fullVolume - partVolume);
        } else if (abi == null && adi == null) {
            Point bci = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, c);
            Point cdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, c, d);
            double partVolume = calculateTetrahedronVolume(c, aci, bci, cdi);
            return partVolume / (fullVolume - partVolume);
        } else if (abi == null && aci == null) {
            Point bdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, d);
            Point cdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, c, d);
            double partVolume = calculateTetrahedronVolume(d, adi, bdi, cdi);
            return partVolume / (fullVolume - partVolume);
        } else if (abi != null & aci != null) {
            Point bdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, d);
            Point cdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, c, d);
            double partVolume = calculateTetrahedronVolume(b, abi, cdi, bdi) +
                    calculateTetrahedronVolume(b, abi, aci, cdi) +
                    calculateTetrahedronVolume(b, c, aci, cdi);
            return partVolume / (fullVolume - partVolume);
        } else if (abi != null & aci == null) {
            Point bci = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, c);
            Point cdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, c, d);
            double partVolume = calculateTetrahedronVolume(b, abi, bci, cdi) +
                    calculateTetrahedronVolume(b, abi, adi, cdi) +
                    calculateTetrahedronVolume(b, d, adi, cdi);
            return partVolume / (fullVolume - partVolume);
        } else {
            Point bci = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, c);
            Point bdi = calculateIntersectionPointOfPlaneAndLine(e, f, g, b, d);
            double partVolume = calculateTetrahedronVolume(c, aci, bci, bdi) +
                    calculateTetrahedronVolume(c, aci, adi, bdi) +
                    calculateTetrahedronVolume(c, d, adi, bdi);
            return partVolume / (fullVolume - partVolume);
        }
    }

    public boolean isTetrahedron(Point a, Point b, Point c, Point d) {
        Point vectorAB = calculateVector(a, b);
        Point vectorAC = calculateVector(a, c);
        // N = VP ( B - A, C - A )
        Point vectorCrossProduct = calculateCrossProduct(vectorAB, vectorAC);
//V = A - X
        Point vectorAD = calculateVector(a, d);
        // расстояние до плоскости по нормали
        //  d = SP ( N, V )
        double distance = dotProduct(vectorCrossProduct, vectorAD);
        return compareDouble(distance, 0.0);
    }

    private boolean compareDouble(double a, double b) {
        return Math.abs(a - b) < Math.ulp(a);
    }

}
