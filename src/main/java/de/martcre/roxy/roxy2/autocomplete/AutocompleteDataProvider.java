package de.martcre.roxy.roxy2.autocomplete;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.DataProviderListener;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.shared.Registration;
import de.martcre.roxy.roxy2.autocomplete.lang.ChainOperator;
import de.martcre.roxy.roxy2.autocomplete.lang.Item;
import de.martcre.roxy.roxy2.autocomplete.lang.Operator;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.text.similarity.FuzzyScore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class AutocompleteDataProvider implements DataProvider<String, String> {

    protected static Logger logger = LogManager.getLogger(AutocompleteDataProvider.class);
    private static Pattern lastWordMatchPattern = Pattern.compile("(\\S*)$");
    private static Pattern wordTokenizerPattern = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");



    @Override
    public Stream<String> fetch(Query<String, String> query) {
        logger.info("fetch " + query.getFilter());
        query.getLimit();
        query.getOffset();

        String input = query.getFilter().orElse("");
        return getSuggestions(input);
    }

    /**
     * Try to interfere the next word.
     *
     * @param input the user typed input
     * @return a stream of possible next words
     */
    private Stream<String> getSuggestions(String input) {

        //  Skip everything if no input is present:
        if (input.isEmpty()) return Stream.of(input);

        Matcher matcher = wordTokenizerPattern.matcher(input);
        List<String> tokenizedInput = new ArrayList<>();
        while(matcher.find()) {
            tokenizedInput.add(matcher.group());
        }
        tokenizedInput.stream().forEach(e -> {logger.info("WORD: " + e);});


        /* TODO Next, take the secondary last and last word and map it to some languange type. Then, validate if
            prefix/suffix is allowed, then put in these as Suggestions! */

        Matcher m = lastWordMatchPattern.matcher(input);
        final String lastWord = (m.find()) ? m.group(1) : "";





        // Input without lastWord, as this is going to be predicted:
        String prefixInput = input.substring(0, input.length() - lastWord.length());

        // Try match against known words:
        Set<Pair<Integer, String>> resultCache = new HashSet<>();

        Set<Item> items = new HashSet<>();
        items.addAll(Arrays.asList(ChainOperator.CHAIN_OPERATORS));
        items.addAll(Arrays.asList(Operator.OPERATORS));

        items.stream().forEach(item -> {
            FuzzyScore fuzzyScore = new FuzzyScore(Locale.ENGLISH);
            resultCache.add(Pair.of(fuzzyScore.fuzzyScore(item.getValue(), lastWord), prefixInput + item.getValue()));
        });

        return Stream.concat(Stream.of(input),
                resultCache.stream()
                    .filter(pair -> (pair.getKey() != 0))
                    .sorted(Comparator.comparing(Pair::getValue))
                    .sorted((pair1, pair2) -> Integer.compare(pair2.getKey(), pair1.getKey()))
                    .map(pair -> new String(pair.getValue())));
    }

    @Override
    public void refreshItem(String item) {

    }

    @Override
    public boolean isInMemory() {
        return true;
    }

    @Override
    public int size(Query<String, String> query) {
        return (int) fetch(query).count();
    }

    @Override
    public void refreshAll() {
    }

    @Override
    public Registration addDataProviderListener(DataProviderListener<String> listener) {
        return null;
    }
}
