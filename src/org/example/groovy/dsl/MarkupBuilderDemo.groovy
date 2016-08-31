package org.example.groovy.dsl
import groovy.xml.MarkupBuilder

/**
 * @author Zero
 * Created on 2016/8/31.
 */


class MarkupBuilderDemo {

    public static void main(String[] args) {
        MarkupBuilder builder = new MarkupBuilder()
        builder.html(lang:'en'){
            head{
                title("首页")
            }

        }

    }
}
