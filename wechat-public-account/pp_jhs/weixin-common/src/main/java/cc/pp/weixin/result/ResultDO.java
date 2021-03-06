package cc.pp.weixin.result;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 返回结果类
 * @author wgybzb
 * @since  2013-04-26
 */
public class ResultDO<T> implements Serializable {

	private static final long serialVersionUID = 2978929281219885697L;

	private boolean isSuccess = true;// 是否成功
	private T model;// 内容
	private final Set<String> errorCodes = new HashSet<String>();// 错误码集合
	private final Map<String/* ERROR-CODE */, String/* ERROR-MSG */> errorMsgs = new HashMap<String, String>();// 错误信息集合

	public ResultDO() {
		//
	}

	public ResultDO(T t) {
		this.model = t;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * 获取错误码集合
	 *
	 * @return
	 */
	public Set<String> getErrorCodes() {
		return new HashSet<String>(errorCodes);
	}

	/**
	 * 获取错误信息集合Map<br/>
	 * KEY:错误码 VAL:错误提示信息
	 *
	 * @return
	 */
	public Map<String, String> getErrorMsgs() {
		return new HashMap<String, String>(errorMsgs);
	}

	/**
	 * 添加错误码
	 * @param errorCode
	 */
	public void addError(String errorCode) {
		this.errorCodes.add(errorCode);
		this.setSuccess(false);
	}

	/**
	 * 添加错误码与错误信息
	 * @param errorCode
	 * @param msg
	 */
	public void addError(String errorCode, String msg) {
		addError(errorCode);
		this.errorMsgs.put(errorCode, msg);
		this.setSuccess(false);
	}

}