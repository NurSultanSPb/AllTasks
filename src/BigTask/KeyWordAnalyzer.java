package BigTask;

public abstract class KeyWordAnalyzer implements TextAnalyzer{
    protected abstract Label getLabel();
    protected abstract String[] getKeywords();
    @Override
    public Label processText(String text) {
        String[] strings = getKeywords();
        for (int i = 0; i < strings.length; i++) {
            if (text.contains(strings[i])) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}
