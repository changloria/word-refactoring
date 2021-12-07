
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String CALCULATE_ERROR = "Calculate Error";
    public static final String NEW_LINE = "\n";

    public String getResult(String sentence){
        try {
            List<WordInfo> wordInfoList = getWordFrequency(sentence);
            wordInfoList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());
            return joinWordtoSentence(wordInfoList);
        } catch (Exception CalculateErrorException) {
            return CALCULATE_ERROR;
        }
    }

    private List<WordInfo> getWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());
        List<WordInfo> wordInfos = new ArrayList<>();
        distinctWords.forEach(distinctWord ->{
            int frequency = (int) words.stream()
                                        .filter(word -> word.equals((distinctWord)))
                                        .count();
            WordInfo wordInfo = new WordInfo(distinctWord, frequency);
            wordInfos.add(wordInfo);
        });
        return wordInfos;
    }

    private String joinWordtoSentence(List<WordInfo> wordInfoList) {
        return wordInfoList.stream()
                .map(wordInfo -> String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount()))
                .collect(Collectors.joining(NEW_LINE));
    }
    

}
