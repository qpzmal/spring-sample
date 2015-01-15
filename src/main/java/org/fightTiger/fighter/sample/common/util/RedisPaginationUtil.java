package org.fightTiger.fighter.sample.common.util;


import java.util.List;

/**
 * 该类是针对redis list寻找msgId的位置，然后取msgId的后面的pageSize条记录
 * 找到后该类用途结束，调用hasNext返回false
 * @author zhangw
 *
 */
public class RedisPaginationUtil {
	private int currentIndex = -1;
	private int pageNo;
	private int pageSize;
	private int maxSize;
	
	public RedisPaginationUtil(int pageNo,int pageSize,int maxSize) {
		// TODO Auto-generated constructor stub
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.maxSize = maxSize;//redis中List规定的大小最多为maxSize这么大
		this.currentIndex = (pageNo-1)*pageSize - 1;
	}
	public class ResultObject{
		private int code;
		private List<String> resultList;
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public List<String> getResultList() {
			return resultList;
		}
		public void setResultList(List<String> resultList) {
			this.resultList = resultList;
		}		
	}
	public  ResultObject currentRedisListPagination(String msgId,List<String> checkList){
		ResultObject returnObject = new ResultObject();
		returnObject.setCode(-1);
		if(checkList==null || checkList.size()==0){
			//如果从redis的List中查询不到更多的数据的时候应该立即结束
			this.currentIndex = maxSize + 1;
			return returnObject;
		}
		
		if(checkList.size()==this.pageSize*3){//正常checkList应该是pageSize的三倍，如果小于，那说明是最后一页，如果大于则程序错误
			this.currentIndex = this.currentIndex+this.pageSize*2;
			List<String> checkSubList = checkList.subList(0, this.pageSize*2);
			for(int i=0;i<checkSubList.size();i++){
				if(msgId.equals(checkSubList.get(i))){
					returnObject.setCode(1);//成功
					returnObject.setResultList(checkList.subList(i+1, i+1+this.pageSize));
					checkSubList.clear();
					//一旦找到mesId的位置就不需要再找了,即下次调用hasNext()时返回false
					this.currentIndex = this.maxSize + 1;
					return returnObject;
				}
			}
		}else if(checkList.size()<this.pageSize*3){
			//这种情况下已经是最后一页了			
			this.currentIndex = this.maxSize +1;
			for(int i=0;i<checkList.size();i++){
				if(msgId.equals(checkList.get(i))&&i!=checkList.size()-1){
					returnObject.setCode(1);//成功
					if(i+this.pageSize<checkList.size()){
						returnObject.setResultList(checkList.subList(i+1, i+1+this.pageSize));
					}else{
						returnObject.setResultList(checkList.subList(i+1, checkList.size()));
					}					
					return returnObject;
				}
			}
		}		
		return returnObject;
	}
	public int nextStart(){		
		return this.currentIndex;
	}
	
	public int nextEnd(){
		return this.currentIndex+this.pageSize*3-1;
	}
	public boolean hasNext(){		
		if(this.currentIndex<this.maxSize){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
	}
}
