package BigTask;
/*
Вы решили абстрагировать фильтр в виде следующего интерфейса:
 */

//функциональный интерфей содержит только один абстрактный публичный метод;

@FunctionalInterface
public interface TextAnalyzer {
    Label processText(String text);
}
