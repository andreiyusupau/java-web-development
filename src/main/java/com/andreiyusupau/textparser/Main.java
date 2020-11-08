package com.andreiyusupau.textparser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Cоздать приложение, разбирающее текст из файла и позволяющее выполнять с текстом три различных операции.
Требования
• Разобранный текст должен быть представлен в виде объекта, содержащего, например, абзацы, предложения, лексемы, слова,
выражения, символы. Лексема – часть текста, ограниченная пробельными символами. Для организации структуры данных
использовать Composite.
• Классы с информацией являются классами сущностей и не должны быть перенагружены методами логики.
• Исходный текст всегда корректный. То есть, все предложения начинаются с заглавной буквы и завершаются символами «.»,
 «?», «!» или «...». Все абзацы начинаются с символа табуляции или заданного числа пробелов, например 4 пробела.
• Разобранный текст необходимо восстановить в первоначальном виде. Пробелы и знаки табуляции при разборе могут заменяться
 одним пробелом.
• Для деления текста на составляющие следует использовать регулярные выражения. Не забывать, что регулярные выражения
 для приложения являются литеральными константами.
• Код, выполняющий разбиение текста на составляющие части, следует оформить в виде классов-парсеров с использованием
 Chain of Responsibility.
• При разработке парсеров, разбирающих текст, необходимо следить количеством создаваемых объектов-парсеров. Их не должно
 быть слишком много.
• Битовые выражения, встречающиеся в тексте, должны быть вычислены. И в итоговый текст (структуру данных) должно войти
вычисленное значение. Использовать Interpreter с применением функциональных интерфейсов.
• Для записи логов использовать Log4J2.
• Созданное приложение должно позволять реализовывать группу задач по работе над текстом (задачи приведены ниже) без
 “переписывания” существующего кода.
• Код должен быть покрыт тестами.
• Класс с методом main в задании должен отсутствовать. Запуск только с применением тестов.
Индивидуальные задания
Функциональные возможности, варианты для реализации
1 Отсортировать абзацы по количеству предложений.
2 В каждом предложении отсортировать слова по длине.
3 Отсортировать лексемы в вхождений заданного символа, а в случае равенства предложении по убыванию количества – по алфавиту.
 */


public class Main {
    public static void main(String... args) {



        //Сортировка абзацев по количеству предложений
        System.out.println("Исходный текст 1: ");
        String text0 = "First sentence. Second sentence!?\n Third sentence? Fourth sentence. Fifth sentence.\n Sixth sentence.";

        String sortedParagraphs = sortParagraphs(text0);

        System.out.println("Текс с отсортированными по количесву предложений параграфами: ");
        System.out.println(sortedParagraphs);


        //т.к. дальше необходимо проверить работу с предложениями - возьмем первое предожение из текста
        System.out.println("Исходный текст 2: ");
        String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        //извлекаем первый абзац
        String par1;
        par1 = getParagraphs(text1).get(0);

        //извлекаем первое предложение
        String sent1;
        sent1 = getSentences(par1).get(0);

        //задаем символ, который будем искать в словах
        char c;
        c = 'e';

        System.out.println("Исходное предложение: ");
        System.out.println(sent1);

        //сортировка слов по вхождению заданного символа и алфавиту
        String sentenceSortedByCharCountAndAlphabet;
        sentenceSortedByCharCountAndAlphabet = sortWordsByCharCountAndAlphabet(sent1, c);

        System.out.println("Предложение со словами отсортированными по частоте вхождения символа \"" + c + "\", а затем по алфавиту: ");
        System.out.println(sentenceSortedByCharCountAndAlphabet);

        //сортировка слов по длине
        String sentenceSortedByWordLength;
        sentenceSortedByWordLength = sortWordsByLength(sent1);

        System.out.println("Предложение со словами отсортированными по длине: ");
        System.out.println(sentenceSortedByWordLength);

    }


    //извлечь абзацы из текста
    private static ArrayList<String> getParagraphs(String text) {

        ArrayList<String> paragraphs = new ArrayList<>();//список абзацев

        //паттерн абзаца(набор символов , который заканчивается знаком переноса строки или конца текста)
//для поочередного нахождения всех абзацев используется ленивый квантификатор +?
        Pattern paragraph;
        paragraph = Pattern.compile("(.+?)(\\z|\\n|\\r|\\f|\\u0085|\\u2029|$)");

        Matcher matcher;
        matcher = paragraph.matcher(text);

        //пока матчер находит совпадения с паттерном добавляем их в список, группа 1 чтобы не учитывать символ переноса
        while (matcher.find()) {
            paragraphs.add(matcher.group(1));
        }
        return paragraphs;
    }

    //извлечь предложения из абзаца
    private static ArrayList<String> getSentences(String paragraph) {
        ArrayList<String> sentences = new ArrayList<>();

        //паттерн предложения
        //для определения всех предложений используем ленивый квантификатор +?
        Pattern sentence;
        sentence = Pattern.compile(".+?(\\?!|!\\?|\\.|!|\\?|\\.\\.\\.)");

        Matcher matcher;
        matcher = sentence.matcher(paragraph);

        //пока матчер находит совпадения с паттерном добавляем их в список
        while (matcher.find()) {
            sentences.add(matcher.group());
        }
        return sentences;
    }

    //извлечь слова из предложения
    private static ArrayList<String> getWords(String sentence) {

        ArrayList<String> words = new ArrayList<>();

        //паттерн слова состоит из двух границ слова , между ними любые буквенно-цифровые символ и знак _
        //для определения всех слов используем ленивый квантификатор +?
        Pattern lexeme;
        lexeme = Pattern.compile("\\b\\w+?\\b");

        Matcher matcher;
        matcher = lexeme.matcher(sentence);

        //пока матчер находит совпадения с паттерном добавляем их в список
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    //сортирвока абзацев по количеству предложений
    public static String sortParagraphs(String text) {

        ArrayList<String> paragraphs;
        paragraphs = getParagraphs(text);//получаем список абзацев

        //сортируем по абзацы по количеству предложений используя метод countSentences.
        paragraphs.sort(Comparator.comparing(Main::countSentences));//по возрастанию

        //paragraphs.sort(Comparator.comparing(RegExp1::countSentences));//по убыванию

        return String.join("\n", paragraphs); //возвращаем текст в виде строки
    }

    //сортировка слов по длине
    public static String sortWordsByLength(String sentence) {
        ArrayList<String> words;
        words = getWords(sentence);//извлекаем слова из предложения

        //сортируем по длине
        words.sort(Comparator.comparing(String::length)); //по возрастанию
        //words.sort(Comparator.comparing(String::length).reversed()); //по убыванию

        return String.join(" ", words); //возвращаем предложение в виде строки
    }

    //отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
    public static String sortWordsByCharCountAndAlphabet(String sentence, char c) {

        ArrayList<String> words;
        words = getWords(sentence);//извлекаем слова из предложения

        //сначала сортируем по возрастанию  количества вхождений символа
        words.sort(Comparator.<String, Integer>comparing(o -> countChar(c, o))
                .thenComparing(Comparator.naturalOrder())); //при равенстве по первому признаку - по алфавиту

        return String.join(" ", words);//возвращаем предложение в виде строки
    }

    //посчитать количество предложений в абзаце
    private static int countSentences(String paragraph) {
        return getSentences(paragraph).size();//возвращаем размер массива предложений извлеченных из абзаца
    }

    //Подсчет количества вхождений заданного символа (возможно здесь не стоило использовать regExp, но на всякий случай)
    private static int countChar(char c, String word) {

        Pattern pattern;
        pattern = Pattern.compile(String.valueOf(c)); //создаем паттерн символа

        Matcher matcher;
        matcher = pattern.matcher(word);

        int count = 0;//счетчик повторений символа в слове

        //считаем вхождения символа в слово
        while (matcher.find()) {
            count++;
        }

        return count;//возвращаем количество
    }
}
