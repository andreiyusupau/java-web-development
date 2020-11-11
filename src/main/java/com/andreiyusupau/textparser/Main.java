package com.andreiyusupau.textparser;

import com.andreiyusupau.textparser.model.Component;
import com.andreiyusupau.textparser.service.parser.Parser;
import com.andreiyusupau.textparser.service.parser.TextParser;

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

        Parser<Component,String> textParser=new TextParser();
       Component component= textParser.parse("One two three. Four me.\nFive six, seven. My [1+2*3] party!\nHello world!");
        System.out.println(component.toString());
    }

//    //сортирвока абзацев по количеству предложений
//    public static String sortParagraphs(String text) {
//
//        ArrayList<String> paragraphs;
//        paragraphs = getParagraphs(text);//получаем список абзацев
//
//        //сортируем по абзацы по количеству предложений используя метод countSentences.
//        paragraphs.sort(Comparator.comparing(Main::countSentences));//по возрастанию
//
//        //paragraphs.sort(Comparator.comparing(RegExp1::countSentences));//по убыванию
//
//        return String.join("\n", paragraphs); //возвращаем текст в виде строки
//    }
//
//    //сортировка слов по длине
//    public static String sortWordsByLength(String sentence) {
//        ArrayList<String> words;
//        words = getWords(sentence);//извлекаем слова из предложения
//
//        //сортируем по длине
//        words.sort(Comparator.comparing(String::length)); //по возрастанию
//        //words.sort(Comparator.comparing(String::length).reversed()); //по убыванию
//
//        return String.join(" ", words); //возвращаем предложение в виде строки
//    }
//
//    //отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
//    public static String sortWordsByCharCountAndAlphabet(String sentence, char c) {
//
//        ArrayList<String> words;
//        words = getWords(sentence);//извлекаем слова из предложения
//
//        //сначала сортируем по возрастанию  количества вхождений символа
//        words.sort(Comparator.<String, Integer>comparing(o -> countChar(c, o))
//                .thenComparing(Comparator.naturalOrder())); //при равенстве по первому признаку - по алфавиту
//
//        return String.join(" ", words);//возвращаем предложение в виде строки
//    }
//
//    //посчитать количество предложений в абзаце
//    private static int countSentences(String paragraph) {
//        return getSentences(paragraph).size();//возвращаем размер массива предложений извлеченных из абзаца
//    }
//
//    //Подсчет количества вхождений заданного символа (возможно здесь не стоило использовать regExp, но на всякий случай)
//    private static int countChar(char c, String word) {
//
//        Pattern pattern;
//        pattern = Pattern.compile(String.valueOf(c)); //создаем паттерн символа
//
//        Matcher matcher;
//        matcher = pattern.matcher(word);
//
//        int count = 0;//счетчик повторений символа в слове
//
//        //считаем вхождения символа в слово
//        while (matcher.find()) {
//            count++;
//        }
//
//        return count;//возвращаем количество
//    }
}
