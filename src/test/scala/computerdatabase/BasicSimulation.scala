package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://loadtest.v.fwmrm.net") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("freewheel")

  val scn = scenario("LoadTest") // A scenario is a chain of requests and pauses
    .exec(http("request_ad")
      .get("/ad/g/1?_dic=1&nw=171224&mode=live&resp=vmap1&prof=169843:playmaker_30fps_cmaf_web&csid=encoding_ladder_test&caid=pck_EP018564820073&asnw=171224&ssnw=171224&vdur=600&pvrn=1452241032&vprn=5992761558&flag=+qtcb-fbad+exvt-vicb-slcb+sltp+amsl+emcr-play-uapl&metr=1031&afid=140315314&sfid=7090576&vip=50.203.232.252&vclr=3.5.1;_fw_h_user_agent=Mozilla/5.0%20(Macintosh;%20Intel%20Mac%20OS%20X%2010_14_4)%20AppleWebKit/537.36%20(KHTML,%20like%20Gecko)%20Chrome/78.0.3904.70%20Safari/537.36&_fw_ae=725bd42fc9c9394e790b9a73610da431&=&_fw_vcid2=171224:1581696585505105023-cK31jf9r-W5QN-Y58N-mw1X-ZlJfdY98dHBD&ltlg=%3C40.7500%3E,%3C-73.9967%3E&_fw_player_width=960&_fw_player_height=540;slid=pre&slau=preroll&tpos=0&ptgt=a;slid=728companion&slau=FW%20Video-728x90%7CFW%20Video-970x66&ptgt=p&flag=+cmpn&w=728&h=90&cd=728,90%7C970,66;slid=728fullscreen&slau=FW%20Video-728x90-Image&ptgt=p&flag=+cmpn&w=728&h=90&cd=728,90%7C970,66;slid=300companion&slau=FW%20Video-300x250%7CFW%20Video-300x600&ptgt=p&flag=+cmpn&w=300&h=250&cd=300,250%7C300,600;slid=bl_overlay&w=1280&h=720&ptgt=s&slau=FW%20Video-Brightline-Overlay&flag=+cmpn"))

  setUp(scn.inject(atOnceUsers(10)).protocols(httpProtocol))
}
