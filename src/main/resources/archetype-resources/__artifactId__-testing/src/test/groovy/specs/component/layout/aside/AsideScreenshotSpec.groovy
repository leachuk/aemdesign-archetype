#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package specs.component.layout.aside

import spock.lang.Stepwise
import spock.lang.Unroll
import support.ComponentSpec

@Stepwise
class AsideScreenshotSpec extends ComponentSpec {

    String pathPage = "component/layout/aside"
    String pathSite = "content/${contentFolderName}-showcase"
    String language = "en"
    String componentPath = "jcr:content/article/par/contentblock1/par/aside"

    def setupSpec() {
        loginAsAdmin()
    }

    @Unroll("Appearance of Component in ${symbol_pound}viewport.label")
    def "Appearance of Component"() {

        given: '>I am in the component showcase page'
        and: '>the component is on the showcase page'
        def selector = "${symbol_pound}plainaside"

        when: 'I am in the component showcase page'
        setWindowSize(viewport)
        waitForAuthorPreviewPage()

        then: 'The component should appear on the page'
        def component = waitForComponent(selector)

        then: 'It should match the small viewport reference image.'
        designRef(selector)

        where:
        viewport << getViewPorts()


    }

}
