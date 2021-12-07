import java.util.*;
import java.util.stream.Collectors;

// naming
// magic string
// temp var
// for loop
// long method
// if / else

public class WordFrequencyGame {
    private static final String SPACE_PATTERN = "\\s+";
    public static final String LINEBREAK_PATTERN = "\n";
    public static final String ERROR_MESSAGE = "Calculate Error";

    public String getResult(String inputStr) {
        try {
            List<WordInfo> wordInfoList = calculateWordFrequency(inputStr);
            wordInfoList.sort(Comparator.comparing(WordInfo::getWordCount).reversed());
            return generateStringResult(wordInfoList);
        } catch (Exception e) {
            return ERROR_MESSAGE;
        }
    }

    private String generateStringResult(List<WordInfo> wordInfoList) {
        return wordInfoList.stream()
                .map(wordInfo -> String.format("%s %d", wordInfo.getValue(), wordInfo.getWordCount()))
                .collect(Collectors.joining(LINEBREAK_PATTERN));
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<String> distinctWords = words.stream().distinct().collect(Collectors.toList());

        List<WordInfo> wordInfoList = new ArrayList<>();
        distinctWords.forEach(distinctWord -> {
            int frequency = (int) words.stream().filter(word -> word.equals(distinctWord)).count();
            WordInfo wordInfo = new WordInfo(distinctWord, frequency);
            wordInfoList.add(wordInfo);
        });

        return wordInfoList;
    }
}
