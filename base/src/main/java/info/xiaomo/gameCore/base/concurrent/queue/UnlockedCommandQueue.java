package info.xiaomo.gameCore.base.concurrent.queue;


import info.xiaomo.gameCore.base.concurrent.executor.QueueMonitor;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 非线程安全的命令队列 任务执行队列，对ArrayDeque的包装. 该队列有一个是否所有队列的任务都执行完毕的标志，用于向队列中添加任务的时候判断是否需要启动任务
 * 
 * @author Administrator
 * @param <V>
 */
public class UnlockedCommandQueue<V> implements ICommandQueue<V>{

	// 命令队列
	private final Queue<V> queue;

	// 队列中的任务是否执行完毕
	private boolean processingCompleted = true;

	private QueueMonitor monitor;

	/**
	 * 创建一个空队列
	 */
	public UnlockedCommandQueue() {
		queue = new ArrayDeque<V>();
	}

	/**
	 * 创建一个空的队列，并用指定的大小初始化该队列
	 * 
	 * @param numElements
	 */
	public UnlockedCommandQueue(int numElements) {
		queue = new ArrayDeque<V>(numElements);
	}

	/**
	 * 下一执行命令
	 * 
	 * @return
	 */
	public V poll() {
		return this.queue.poll();
	}

	/**
	 * 增加执行指令
	 * 
	 * @return
	 */
	public boolean offer(V value) {
		return this.queue.offer(value);
	}

	/**
	 * 清理
	 */
	public void clear() {
		this.queue.clear();
	}

	/**
	 * 获取指令数量
	 * 
	 * @return
	 */
	public int size() {
		return this.queue.size();
	}

	

	public boolean isProcessingCompleted() {
		return this.processingCompleted;
	}

	public void setProcessingCompleted(boolean processingCompleted) {
		this.processingCompleted = processingCompleted;
	}


	@Override
	public QueueMonitor getMonitor() {
		return monitor;
	}

	@Override
	public void setMonitor(QueueMonitor monitor) {
		this.monitor = monitor;
	}
}
