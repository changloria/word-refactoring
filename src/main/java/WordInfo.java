public class WordInfo {
    private String word;
    private int count;

    public WordInfo(String word, int i){
        this.word =word;
        this.count =i;
    }


    public String getValue() {
        return this.word;
    }

    public int getWordCount() {
        return this.count;
    }


}
