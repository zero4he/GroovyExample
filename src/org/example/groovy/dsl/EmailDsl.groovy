package org.example.groovy.dsl

/**
 * 自定义DSL
 *
 * 参考:http://docs.groovy-lang.org/docs/latest/html/documentation/core-domain-specific-languages.html
 *
 * @author Zero
 *
 * Created on 2016/8/31.
 */
class EmailDsl {
    String from;
    String to;
    String body;

    def static send(closure) {
        EmailDsl dsl = new EmailDsl()
        // any method called in closure will be delegated to the memoDsl class
        closure.delegate = dsl
        closure() //执行,突然想起了js的闭包(function(){})()
        closure.autoSend() //这里发送邮件
    }


    def to(String to) {
        this.to = to
    }

    def from(String from) {
        this.from = from
    }

    def body(String body) {
        this.body = body
    }

    private autoSend() {
        println("正在发生邮件...")
        println("From: " + from)
        println("To: " + to)
        println(body)
        println("发送完毕")
    }

    /**
     * <pre>
     * 如果没有定义改方法,在闭包中确调用了不存在的方法,会抛出MissingMethodException异常
     *
     *
     * </pre>
     * @param methodName
     * @param args
     * @return
     */
    def methodMissing(String methodName, args) {
        println("方法丢失:$methodName()\n")
    }

    public static void main(String[] args) {
        EmailDsl.send({
            from "zero.he@ccjk.com" //会调用from()方法
            to "may.xie@ccjk.com"
            body("hello")
            undefMethod()//为定义方法,会调用methodMissing()方法
        })
    }
}
