1、多个if else 
if("BATCH_1".equals(taskType)){
   //批量转仓逻辑
}else if("BATCH_2".equals(taskType)){
   //批量转快递逻辑
}else if("BATCH_3".equals(taskType)){
   //批量替换订单商品逻辑
}else if("BATCH_4".equals(taskType)){
   //批量伤处订单商品逻辑
}else if("BATCH_5".equals(taskType)){
   //批量添加备注逻辑
}else{
   System.out.println("任务类型无法处理");
}

改为使用策略模式：
1、抽象业务处理器
public abstract class InspectionSolver{
    public abstract void solve(Long orderId, Long userId);
    public abstract String[] supports();
}

2、将业务处理器和其支持处理的类型放到一个容器中(Map)
@Component
public class InspectionSolverChooser implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Map<String, InspectionSolver> chooseMap = new HashMap<>();
    public InspectionSolver choose(String type){
        return chooseMap.get(type);
    }
    @PostConstruct
    public void register(){
        Map<String, InspectionSolver> solverMap = applicationContext.getBeansOfType(InspectionSolver.class);
        for(InspectionSolver solver : solverMap.values()){
            for(String support : solver.supports()){
                chooseMap.put(support, solver);
            }
        }
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}