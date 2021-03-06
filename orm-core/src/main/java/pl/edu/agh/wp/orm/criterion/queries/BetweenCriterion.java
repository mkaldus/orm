package pl.edu.agh.wp.orm.criterion.queries;

import pl.edu.agh.wp.orm.postres.DatabaseStatement;

public class BetweenCriterion extends AbstractCriterion {

    private String supportOperator;
    private Object minValue;
    private Object maxValue;

    public BetweenCriterion(String column, Object minValue, Object maxValue){
        super();
        this.column = column;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.operator = DatabaseStatement.BETWEEN;
        this.supportOperator = DatabaseStatement.AND;
        buildQuery();
    }

    @Override
    public void buildQuery() {
        appendWithSpace(column);
        appendWithSpace(operator);
        appendArgument(minValue);
        appendWithSpace("");
        appendWithSpace(supportOperator);
        appendArgument(maxValue);
    }

}
