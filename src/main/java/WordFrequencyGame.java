
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String CALCULATE_ERROR = "Calculate Error";
    public static final String NEW_LINE = "\n";

    //public method should put at front, private method should put at back (priority la)
    public String getResult(String sentence){
        try {
            List<WordInfo> wordInfoList = getWordFrequency(sentence);
            wordInfoList.sort(Comparator.comparingInt(WordInfo::getWordCount).reversed());
            return joinWordtoSentence(wordInfoList);
        } catch (Exception CalculateErrorException) {
            return CALCULATE_ERROR;
        }
    }

    private List<WordInfo> getWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());

        return distinctWords.stream()
                .map(word -> new WordInfo(word, Collections.frequency(words, word)))
                .collect(Collectors.toList());
    }

    private String joinWordtoSentence(List<WordInfo> wordInfoList) {
        return wordInfoList.stream()
                .map(wordInfo -> String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount()))
                .collect(Collectors.joining(NEW_LINE));
    }
    

}
