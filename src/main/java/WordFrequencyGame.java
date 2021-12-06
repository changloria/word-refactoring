import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";

    public String getResult(String sentence){
        try {
            List<WordInfo> wordInfoList = getWordInfoList(sentence);
            wordInfoList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());
            return getString(wordInfoList);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }
    private List<WordInfo> getWordInfoList(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());
        List<WordInfo> wordInfos = new ArrayList<>();
        distinctWords.forEach(distinctWord ->{
            int frequency = (int) words.stream().filter(word -> word.equals((distinctWord))).count();
            WordInfo wordInfo = new WordInfo(distinctWord, frequency);
            wordInfos.add(wordInfo);
        });
        return wordInfos;
    }

    private String getString(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (WordInfo wordInfo : wordInfoList) {
            String word = wordInfo.getValue()+" "+wordInfo.getWordCount();
            joiner.add(word);
        }
        return joiner.toString();
    }
    

}
