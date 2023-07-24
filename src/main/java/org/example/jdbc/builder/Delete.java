package org.example.jdbc.builder;

import org.example.jdbc.builder.constant.Table;

public class Delete {

    private final StringBuilder query = new StringBuilder();

    private Table table;
    private Where where;

    private Delete(Table table, Where where) {
        this.table = table;
        this.where = where;

        makeQuery();
    }

    public static class Builder {

        private Table table;
        private Where where;

        public Builder delete(Table table) {
            this.table = table;

            return this;
        }

        public Builder where(Where where) {
            this.where = where;

            return this;
        }

        public Delete build() {
            return new Delete(table, where);
        }

    }

    private void makeQuery() {
        query.append(String.format("DELETE %s", table));

        if (where != null) {
            query.append(String.format(" %s", where.getQuery()));
        }
    }

    public String getQuery() {
        return query.toString();
    }

}
