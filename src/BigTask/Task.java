package BigTask;
/*
Вы хотите фильтровать комментарии по разным критериям, уметь легко добавлять новые фильтры и модифицировать старые.
Допустим, мы будем фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.
 */
public class Task {
    String comment = "w:|mwsmkwsmkmkmkfwejhfkjwekefwjkefwjkefwjefwjkefw";
    public static void main(String[] args) {
        String text = "My name is Nursultan!";
        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(new String[]{"wdn", "nf", "djwnjnwd"});
        System.out.println(spamAnalyzer.processText(text));
        NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
        System.out.println(negativeTextAnalyzer.processText(text));
        TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(19);
        System.out.println(tooLongTextAnalyzer.processText(text));
        Task task = new Task();
        System.out.println(task.checkLabels(new TextAnalyzer[]{spamAnalyzer, negativeTextAnalyzer, tooLongTextAnalyzer}, task.comment));
    }
    //последний результирующий метод, если все анализаторы вернули ОК, возвращает ОК метку, иначе первый не-ОК метку
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
       for (TextAnalyzer test: analyzers) {
           if (test.processText(text) != Label.OK) {
               return test.processText(text);
           }
       }
        return Label.OK;
    }
}
