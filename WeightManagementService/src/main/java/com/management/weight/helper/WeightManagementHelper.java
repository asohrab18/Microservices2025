package com.management.weight.helper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.management.weight.exception.MissingRequiredDataException;
import com.management.weight.model.Person;
import com.management.weight.utils.WeightManagementContants;
import com.management.weight.utils.WeightManagementUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class WeightManagementHelper {
	private static final Logger LOG = LoggerFactory.getLogger(WeightManagementHelper.class);

	public Person getDetails(Person person) throws Exception {
		float currentWeightInKg = person.getCurrentWeightInKg();
		float desiredWeightInKg = person.getDesiredWeightInKg();
		int caloriesLossPerDay = person.getCaloriesLossPerDay();
		if (caloriesLossPerDay == WeightManagementContants.ZERO) {
			LOG.info(WeightManagementContants.MSG_ZERO_CAL_LOSS_PER_DAY);
			throw new MissingRequiredDataException(WeightManagementContants.MSG_ZERO_CAL_LOSS_PER_DAY);
		}
		if (currentWeightInKg == WeightManagementContants.ZERO) {
			LOG.info(WeightManagementContants.MSG_ZERO_CURRENT_WT);
			throw new MissingRequiredDataException(WeightManagementContants.MSG_ZERO_CURRENT_WT);
		}
		if (desiredWeightInKg == WeightManagementContants.ZERO) {
			LOG.info(WeightManagementContants.MSG_ZERO_DESIRED_WT);
			throw new MissingRequiredDataException(WeightManagementContants.MSG_ZERO_DESIRED_WT);
		}
		if (currentWeightInKg < desiredWeightInKg) {
			LOG.info(WeightManagementContants.MSG_CURRENT_WT_LT_DESIRED_WT);
			throw new MissingRequiredDataException(WeightManagementContants.MSG_CURRENT_WT_LT_DESIRED_WT);
		}
		float requiredWeightLossInKg = WeightManagementUtils.getWeightDifference(currentWeightInKg, desiredWeightInKg);
		LocalDateTime currentDate = WeightManagementUtils.getLocalDateTime(WeightManagementContants.ZERO);
		String today = WeightManagementUtils.formatLocalDateTime(currentDate);
		float daysToLossOnekgWeight = WeightManagementUtils.getDaysToLossRequiredWeight(caloriesLossPerDay,
				WeightManagementContants.ONE);
		float daysToLossRequiredWeight = WeightManagementUtils.getDaysToLossRequiredWeight(caloriesLossPerDay,
				requiredWeightLossInKg);
		float monthsToLossRequiredWeight = WeightManagementUtils.getMonths(daysToLossRequiredWeight);
		float yearsToLossRequiredWeight = WeightManagementUtils.getYears(monthsToLossRequiredWeight);
		long seconds = WeightManagementUtils.getSeconds(daysToLossRequiredWeight);
		LocalDateTime nextTime = WeightManagementUtils.getLocalDateTime(seconds);
		String achievementDay = WeightManagementUtils.formatLocalDateTime(nextTime);

		person.setRequiredWeightLossInKg(requiredWeightLossInKg);
		person.setToday(today);
		person.setDaysToLossOnekgWeight(daysToLossOnekgWeight);
		person.setDaysToLossRequiredWeight(daysToLossRequiredWeight);
		person.setMonthsToLossRequiredWeight(monthsToLossRequiredWeight);
		person.setYearsToLossRequiredWeight(yearsToLossRequiredWeight);
		person.setAchievementDay(achievementDay);
		LOG.info(WeightManagementContants.MSG_SUCCESSFUL);
		return person;
	}
}