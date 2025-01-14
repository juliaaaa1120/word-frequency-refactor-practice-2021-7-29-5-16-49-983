import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WordFrequencyGameTest {

    @Test
    public void should_return_the_1_when_get_result_given_input_the() throws Exception {
        //Given
        String inputStr = "the";
        String expectResult = "the 1";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    @Test
    public void should_return_the_1_is_1_when_get_result_given_input_the_is() throws Exception {
        //Given
        String inputStr = "the is";
        String expectResult = "the 1\nis 1";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    @Test
    public void should_return_the_1_is_1_when_get_result_given_input_the_is_with_special_spaces() throws Exception {
        //Given
        String inputStr = "the      is";
        String expectResult = "the 1\nis 1";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    @Test
    public void should_return_the_1_is_1_when_get_result_given_input_the_is_with_special_enter() throws Exception {
        //Given
        String inputStr = "the   \n   is";
        String expectResult = "the 1\nis 1";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    @Test
    public void should_return_the_2_is_1_when_get_result_given_input_the_the_is_with_sorted() throws Exception {
        //Given
        String inputStr = "the the is";
        String expectResult = "the 2\nis 1";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    @Test
    public void should_return_is_2_the_1_when_get_result_given_input_the_is_is_sorted_with_count_descending() throws Exception {
        //Given
        String inputStr = "the is is";
        String expectResult = "is 2\nthe 1";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    @Test
    public void should_return_calculate_error_when_get_result_given_input_null() throws Exception {
        //Given
        String inputStr = null;
        String expectResult = "Calculate Error";
        validate_input_string_process_to_expected_string(inputStr, expectResult);
    }

    private void validate_input_string_process_to_expected_string(String inputStr, String expectResult) {
        WordFrequencyGame wordFrequencyGame = new WordFrequencyGame();
        //When
        String actualResult = wordFrequencyGame.getResult(inputStr);
        //Then
        assertThat(actualResult).isEqualTo(expectResult);
    }
}
