package LearnMore.example.LearnMore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
public class LearnMoreApplication {
	public static void main(String[] args)  {
//		Persion a = new Persion("a", 23);
//		Persion b = a;
//
//		String s1 = "hello";
//		String s2 = new String("hello");
//
//		System.out.println(s1.equals(s2));

//		HashMap<Integer, String> map = new HashMap<>();
//
//		// Hai key này có thể tạo hashCode khác nhau nhưng cùng bucket index
//		map.put(null, "One");
//		map.put(17, "Seventeen"); // giả sử capacity = 16, 1 % 16 = 1, 17 % 16 = 1 → collision
//
//		System.out.println(map.get(1));   // One
//		System.out.println(map.get(17));  // Seventeen
//		CounterSyncLock counterSync = new CounterSyncLock();
////
////		Runnable task = () -> {
////			for (int i = 0; i < 3; i++) {
////				counterSync.increment();
////			}
////		};
////
////		Thread thread1 = new Thread(task);
////		Thread thread2 = new Thread(task);
////
////		thread1.start();
////		thread2.start();
////
////		thread1.join();
////		thread2.join();
////
////		System.out.println("Get count: "+ counterSync.getCount());
//		int[] nums = new int[] {0,3,2,5,4,6,1,1};
//		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
//		LinkedHashSet<Integer> arrExists = new LinkedHashSet<Integer>();
//
//		for (int i = nums.length - 1; i > 0; i--) {
//			if (arrExists.contains(nums[i]) || (nums[i] - nums[i-1] != 1)) {
//				continue;
//			}
//			arrExists.add(nums[i]);
//
//		}
//		arrExists.add(nums[0]);
//		System.out.println(arrExists.size());

//		String s = "Was it a car or a cat I saw?";
//
//		Pattern pattern = Pattern.compile("[A-Za-z0-9]");
//		Matcher matcher = pattern.matcher(s);
//
//		StringBuilder sb = new StringBuilder();
//		while (matcher.find()) {
//			sb.append(matcher.group());
//		}
//
//		System.out.println(sb.reverse().toString().toLowerCase().equals(sb.toString().toLowerCase()));

//		int[] numbers = {1, 2, 3, 4, 5};
//		int target = 6;
//		int[] result = new int[] {};
//		for (int i = 0; i < numbers.length; i++)
//		{
//			int left = i + 1, right = numbers.length - 1;
//			int tmp = target - numbers[i];
//			while(left <= right) {
//				int mid = left + (right - left) / 2;
//				if (numbers[mid] == tmp) {
//					result = new int[] {i +1, mid + 1};
//				} else if (numbers[mid] < tmp) {
//					left = mid + 1;
//				} else {
//					right = mid - 1;
//				}
//			}
//		}
//
//		System.out.println(Arrays.toString(result));
//		int[] nums = {-1,0,1,2,-1,-4};
//		List<List<Integer>> result = new ArrayList<>();
//		for(int i = 0; i < nums.length; i++) {
//			if (nums[i] > 0) break;// mảng luôn dương
//			if (i > 0 && nums[i] == nums[i-1]) continue; // đã duyệt giá trị i - 1 rồi bỏ qua i nếu i = i-1
//			int l = i + 1, r = nums.length - 1;
//			while (l < r) {
//				int sum = nums[i] + nums[l] + nums[r];
//				if (sum > 0) {
//					r--;
//				} else if (sum < 0) {
//					l++;
//				} else {
//					result.add(Arrays.asList(nums[i], nums[l], nums[r]));
//					l++;
//					r--;
//					while (l < r && nums[l] == nums[l-1]) {
//						l++;
//					}
//				}
//			}
//		}

//		int[] height = {1,7,2,5,4,7,3,6};
//		int l = 0;
//		int r = height.length - 1;
//		int res = 0;
//		while(l < r) {
//			int area = Math.min(height[l], height[r]) * (r - l);
//			res = Math.max(res, area);
//			if (height[l] <= height[r]) {
//				l++;
//			} else{
//				r--;
//			}
//		}
		SpringApplication.run(LearnMoreApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//
//		};
//	}

//	@Bean
//	public CommandLineRunner runKafka(ProducerKafka producerKafka) {
//		return args -> {
//			for (int i = 0; i < 5; i++) {
//				producerKafka.send("test-topic", "Hello Kafka " + i);
//			};
//		};
//	}

}

//class CounterSync {
//	private int count;
//
//	public synchronized void increment() {
//		count++;
//	}
//
//	public int getCount() {
//		return count;
//	}
//}

//class CounterSyncLock {
//	private int count;
//	private Lock lock = new ReentrantLock();
//
//	public void increment() {
//		if (lock.tryLock()) {
//			try {
//				count++;
//			} finally {
//				lock.unlock();
//			}
//		} else {
//			System.out.println("Không lấy được lock bỏ qua!");
//		}
//	}
//
//	public int getCount() {
//		return count;
//	}
//}

