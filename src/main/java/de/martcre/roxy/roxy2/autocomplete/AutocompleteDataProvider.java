package de.martcre.roxy.roxy2.ui;

import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.DataProviderListener;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.shared.Registration;
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
    private static Pattern wordMatchPattern = Pattern.compile("(\\S*)$");

    private String[] knownColumns = new String[]{"id", "firstName", "firstBorn", "fiZZZ", "lastName", "homeAdress", "otherAdresses"};
    private String[] knownConnectors = new String[]{"AND", "OR"};
    private String[] knownOperators = Arrays.stream(TabberOperatorType.values()).map(TabberOperatorType::toString).toArray(String[]::new);

    @Override
    public Stream<String> fetch(Query<String, String> query) {
        logger.info("fetch " + query.getFilter());
        query.getLimit();
        query.getOffset();

        String input = query.getFilter().orElse("");

        Matcher m = wordMatchPattern.matcher(input);
        String lastWord = "";
        if (m.find()) {
            lastWord = m.group(1);
            logger.info("Last Word: " + lastWord);
        }

        return Stream.concat(Stream.of(input), getSuggestions(input, lastWord));
    }

    private Stream<String> getSuggestions(String input, String lastWord) {
        //  Skip everything if no lastWord is present:
        if (lastWord.isEmpty()) return Stream.of(lastWord);

        // Input without lastWord, as this is going to be predicted:
        String prefixInput = input.substring(0, input.length() - lastWord.length());

        // Try match against known words:
        Set<Pair<Integer, String>> cache = new HashSet<>();

        Set<String> items = new HashSet<>();
        items.addAll(Arrays.asList(knownColumns));
        items.addAll(Arrays.asList(knownConnectors));
        items.addAll(Arrays.asList(knownOperators));

        items.stream().forEach(item -> {
            FuzzyScore fuzzyScore = new FuzzyScore(Locale.ENGLISH);
            cache.add(Pair.of(fuzzyScore.fuzzyScore(item, lastWord), prefixInput + item));
        });

        return cache.stream()
                .filter(pair -> (pair.getKey() != 0))
                .sorted(Comparator.comparing(Pair::getValue))
                .sorted((pair1, pair2) -> Integer.compare(pair2.getKey(), pair1.getKey()))
                .map(pair -> new String(pair.getValue()));
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
