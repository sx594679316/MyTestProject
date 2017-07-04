/**
 * @author sunxin
 * @date 2017年7月4日 下午3:05:35
 */
public class Factory {

	public static Work getWork(String product) {
		if ("phone".equals(product)) {
			return new Phone();
		} else if ("tv".equals(product)) {
			return new Tv();
		}
		return null;
	}
}
