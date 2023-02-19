package zzz;

import cn.hutool.core.io.FileUtil;
import lombok.Getter;
import lombok.Setter;

import java.text.NumberFormat;

@Setter
@Getter
public class StopWatch extends cn.hutool.core.date.StopWatch {

	private boolean taskSuccessFlag = true;

	public String prettyPrint() {
		StringBuilder sb = new StringBuilder(shortSummary());
		sb.append(FileUtil.getLineSeparator());

		sb.append("---------------------------------------------").append(FileUtil.getLineSeparator());
		sb.append("ns\t\t\t%\t\tTask name\tstatus").append(FileUtil.getLineSeparator());
		sb.append("---------------------------------------------").append(FileUtil.getLineSeparator());

		final NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(9);
		nf.setGroupingUsed(false);

		final NumberFormat pf = NumberFormat.getPercentInstance();
		pf.setMinimumIntegerDigits(3);
		pf.setGroupingUsed(false);
		for (TaskInfo task : getTaskInfo())
			sb
					.append(nf.format(task.getTimeNanos())).append("\t")
					.append(pf.format((double) task.getTimeNanos() / getTotalTimeNanos())).append("\t")
					.append(task.getTaskName()).append("\t\t")
					.append(taskSuccessFlag).append(FileUtil.getLineSeparator());

		return sb.toString();
	}

}
