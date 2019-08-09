//package cn.spring.mvn.redis.test;
//
//import java.util.Map;
//
//public class DMBClientTester
//{
//  protected String sendPkgFile;
//  protected String targetDcnNo;
//  protected String serviceId;
//  protected String scenarioId;
//  protected int timeout;
//  protected boolean errorStack;
//  protected TestType type;
////  protected LTTSConstants.ServiceMode mode;
//  protected boolean printInput;
//  protected int sendCount;
//  protected boolean localTest;
//  protected boolean testPkg;
//  protected ThreadLocal<String> consumerSeqNo;
//  protected String bizSeqNo;
//  protected String reversalSeqNo;
//  protected int nThreads;
//  protected Map reponsePkgMap;
//  private Map<String, Object> sendPkgMap;
////  private DMBRequest dmbRequest;
////  private OgnlExpressionEvaluator ee;
//
//  @Rule
//  public DMBClientRule rmbClientRule;
//  protected Map<String, String> assertSet;
//
//  public DMBClientTester()
//  {
//    this.sendPkgFile = "";
//
//    this.targetDcnNo = "";
//    this.serviceId = "";
//    this.scenarioId = "";
//    this.timeout = 0;
//    this.errorStack = true;
//    this.type = TestType.success;
//    this.mode = LTTSConstants.ServiceMode.Sync;
//    this.printInput = true;
//    this.sendCount = 1;
//    this.localTest = false;
//    this.testPkg = false;
//    this.consumerSeqNo = new ThreadLocal() {
//      protected String initialValue() {
//        return RandomStringUtils.randomNumeric(32);
//      }
//    };
//    this.bizSeqNo = RandomStringUtils.randomNumeric(32);
//
//    this.nThreads = 1;
//
//    this.ee = new OgnlExpressionEvaluator();
//
//    OgnlRuntime.setPropertyAccessor(JSONArray.class, new ListPropertyAccessor()
//    {
//      public void setProperty(Map context, Object target, Object name, Object value) throws OgnlException {
//        List list = (List)target;
//        try {
//          super.setProperty(context, target, name, value);
//        }
//        catch (IndexOutOfBoundsException e) {
//          list.add(value);
//        }
//      }
//    });
//    this.rmbClientRule = new DMBClientRule(this);
//
//    this.assertSet = new HashMap();
//  }
//
//  @BeforeClass
//  public static void setUp()
//  {
//    System.setProperty("ltts.home", System.getProperty("user.dir"));
//    System.setProperty("rmb.dcn.no", "A00");
//    System.setProperty("rmb.system.id", "3009");
//  }
//
//  protected void initSendPkgMapByFile()
//  {
//    initSendPkgMapByFile(this.sendPkgFile);
//  }
//
//  protected void initSendPkgMapByFile(String sendPkgFile) {
//    File path = new File(sendPkgFile);
//    if (!path.exists())
//      throw LangUtil.wrapThrow("发送报文不存在！[%s]", new String[] { path.getAbsolutePath() });
//    try
//    {
//      System.out.println("发送报文文件路径：" + path.getAbsolutePath());
//      String content = FileUtils.readFileToString(path);
//      initSendPkgMapByContent(content);
//    } catch (Exception ex) {
//      throw LangUtil.wrapThrow("报文解析失败![%s]", new String[] { path.getAbsolutePath() });
//    }
//  }
//
//  protected void initSendPkgMapByContent(String content) {
//    this.sendPkgMap = JsonUtil.parse(content);
//    if (this.errorStack)
//      setPkgUseExp("sys.errorStack", "1");
//  }
//
//  private void initDMBRequest()
//  {
//    try {
//      String sendPkgContent = "^^^";
//      if (!this.testPkg) {
//        sendPkgContent = JSON.toJSONString(this.sendPkgMap, false);
//      }
//
//      if (this.consumerSeqNo.get() == null) {
//        this.consumerSeqNo.set(RandomStringUtils.randomNumeric(32));
//      }
//      System.out.println("业务流水:" + this.bizSeqNo);
//      System.out.println("系统调用流水：" + (String)this.consumerSeqNo.get());
//      System.out.println("当前系统编号：" + DMBUtil.getIntanse().getConfiguredSysId());
//      System.out.println("目标DCN：" + this.targetDcnNo);
//      this.dmbRequest = new DMBRequest();
//      this.dmbRequest.setTimeout(this.timeout);
//      this.dmbRequest.setContent(sendPkgContent);
//      this.dmbRequest.setBizSeqNo(this.bizSeqNo);
//      this.dmbRequest.setConsumerSeqNo((String)this.consumerSeqNo.get());
//
//      DMBDestination dest = new DMBDestination(this.serviceId, this.scenarioId, this.targetDcnNo);
//      this.dmbRequest.setDestination(dest);
//    } catch (Exception ex) {
//      throw LangUtil.wrapThrow(ex);
//    } finally {
//      this.consumerSeqNo.set(null);
//    }
//  }
//
//  protected void sendDMB() {
//    initDMBRequest();
//    long start = System.currentTimeMillis();
//
//    DMBResponse respObj = DMBUtil.getIntanse().send(this.dmbRequest);
//    if ((this.printInput) && (!this.testPkg)) {
//      System.out.println("请求报文>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//      String sendContent = JsonUtil.formatWithPretty(JsonUtil.parse(this.dmbRequest.getContent()));
//      System.out.println(sendContent);
//    }
//    long end = System.currentTimeMillis();
//    if (this.mode == LTTSConstants.ServiceMode.Async) {
//      System.out.println("异步发送成功>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//      return;
//    }
//    System.out.println("响应报文>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//    if (!this.testPkg) {
//      System.out.println(JsonUtil.formatWithPretty(this.reponsePkgMap = JsonUtil.parse(respObj.getContent())));
//      String errortx = (String)getValue(this.reponsePkgMap, "sys.erortx");
//      if (!StringUtils.isEmpty(errortx)) {
//        System.out.println("错误描述>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(errortx);
//      }
//    }
//    else {
//      System.out.println(respObj.getContent());
//    }
//    System.out.println("耗时:" + (end - start) + " 毫秒");
//  }
//
//  protected void doAssert() {
//    for (String key : this.assertSet.keySet()) {
//      Object expected = this.assertSet.get(key);
//      Object actual = getValue(this.reponsePkgMap, key);
//      Assert.assertEquals(expected, actual);
//    }
//  }
//
//  protected void setPkgUseExp(String expression, String value)
//  {
//    try
//    {
//      Object valueObj;
//      try
//      {
//        Object valueObj;
//        if ((value.startsWith("{")) || (value.startsWith("["))) {
//          valueObj = Json.fromJson(value);
//        }
//        else
//          valueObj = value;
//      } catch (JsonException e) {
//        e.printStackTrace();
//        throw LangUtil.wrapThrow(e);
//      }
//      setValue(this.sendPkgMap, expression, valueObj);
//    } catch (Exception e) {
//      throw LangUtil.wrapThrow(e);
//    }
//  }
//
//  protected void setValue(Map<String, Object> map, String expression, Object valueObj) {
//    this.ee.setValue(this.sendPkgMap, null, expression, valueObj, true);
//  }
//
//  protected Object getValue(Map<String, Object> map, String expression) {
//    return this.ee.findValue(expression, map, null);
//  }
//
//  protected void setCommReq(String exp, String value)
//  {
//    setPkgUseExp("comm_req." + exp, value);
//  }
//
//  protected void setInput(String exp, String value)
//  {
//    setPkgUseExp("input." + exp, value);
//  }
//
//  protected void assertRet(String exp, String value)
//  {
//    this.assertSet.put(exp, value);
//  }
//}
