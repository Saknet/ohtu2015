package statistics;

import statistics.matcher.*;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
    }

    private QueryBuilder(Matcher matcher) {
        this.matcher = matcher;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        if (this.matcher == null) {
            return new QueryBuilder(new HasAtLeast(value, category));
        } else {
            return new QueryBuilder(new And(this.matcher, new HasAtLeast(value, category)));
        }
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        if (this.matcher == null) {
            return new QueryBuilder(new HasFewerThan(value, category));
        } else {
            return new QueryBuilder(new And(this.matcher, new HasFewerThan(value, category)));
        }
    }
    
    public QueryBuilder not() {
        return new QueryBuilder(new Not(this.matcher));
    }
    
    public QueryBuilder playsIn(String team) {
        if (this.matcher == null) {
            return new QueryBuilder(new PlaysIn(team));
        } else {
            return new QueryBuilder(new And(this.matcher, new PlaysIn(team)));
        }
    }

    public QueryBuilder oneOf(Matcher matcher1, Matcher matcher2) {
        return new QueryBuilder(new Or(matcher1, matcher2));
    }

    public Matcher build() {
        return this.matcher;
    }
}