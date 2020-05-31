package de.martcre.roxy.roxy2.backend;

import com.vaadin.flow.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.DataProviderListener;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.shared.Registration;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.FilterItem;

import java.util.Set;
import java.util.stream.Stream;

public class TabberDataProvider implements ConfigurableFilterDataProvider<Row, Void, Set<FilterItem>> {

    @Override
    public void setFilter(Set<FilterItem> filter) {

    }

    @Override
    public boolean isInMemory() {
        return false;
    }

    @Override
    public int size(Query<Row, Void> query) {
        return 0;
    }

    @Override
    public Stream<Row> fetch(Query<Row, Void> query) {
        return null;
    }

    @Override
    public void refreshItem(Row item) {

    }

    @Override
    public void refreshAll() {

    }

    @Override
    public Registration addDataProviderListener(DataProviderListener<Row> listener) {
        return null;
    }
}
