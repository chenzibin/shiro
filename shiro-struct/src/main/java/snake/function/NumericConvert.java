package snake.function;

public class NumericConvert implements Convertible<Integer> {

    /*变量因子*/
    private Integer factor = 1;

    @Override
    public Integer convert(Integer integer) {
        return integer + factor++;
    }
}
