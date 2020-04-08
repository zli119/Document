package com.utpe;

import com.utpe.dataProcess.fileReader.*;

import java.util.*;

public final class Test {
    public final int a;
    public static int b;
    protected int c;
    public final void check() {

    }
    private Test() {
        a = 5;
        b = 6;
    }
    private class Test3{
        void get() {
            b = 9;
        }
    }
    Test3 t3 = new Test3();
    public static void main(String[] args) {
        // test Reader
        String filePath = "politics\\guns\t15550\t479\tFrom: strnlght@netcom.com (David Sternlight) Subject: Re: The Escrow Database. Organization: DSI/USCRPAC Lines: 17  In article <tcmayC5rs6n.Lz8@netcom.com> tcmay@netcom.com (Timothy C. May) writes:  > >After the Waco Massacre and the Big Brother Wiretap Chip, any tactic >is fair.  This is pernicious nonsense!  David    --  David Sternlight         Great care has been taken to ensure the accuracy of                          our information, errors and omissions excepted.      politics\\guns\t53299\t2859\tFrom: arc@cco.caltech.edu (Aaron Ray Clements) Subject: Re: Gun Control (was Re: We're Mad as Hell at the TV News) Article-I.D.: gap.1ppu9hINNl0v Distribution: na Organization: California Institute of Technology, Pasadena Lines: 57 NNTP-Posting-Host: sandman.caltech.edu  manes@magpie.linknet.com (Steve Manes) writes:  >hambidge@bms.com wrote: >: In article <C4psoG.C6@magpie.linknet.com>, manes@magpie.linknet.com (Steve Manes) writes:  >: >: Rate := per capita rate.  The UK is more dangerous. >: >: Though you may be less likely to be killed by a handgun, the average >: >: individual citizen in the UK is twice as likely to be killed >: >: by whatever means as the average Swiss.  Would you feel any better >: >: about being killed by means other than a handgun? I wouldn't. >:  >: >What an absurd argument.  Switzerland is one-fifth the size of the >: >UK with one-eigth as many people therefore at any given point on >: >Swiss soil you are more likely to be crow bait.  More importantly, >: >you are 4x as likely to be killed by the next stranger approaching >: >you on a Swiss street than in the UK.  Killed by handgun, or killed?  If I'm dead, I don't much care if it was by being shot or stabbed to death.  >: You are betraying your lack of understanding about RATE versus TOTAL >: NUMBER. Rates are expressed, often, as #/100,000 population. >: Therefore, if a place had 10 deaths and a population of 100,000, the >: rate would be 10/100,000.  A place that had 50 deaths and a population >: of 1,000,000 would hav a rate of 5/100,000.  The former has a higher >: rate, the latter a higher total.  You are less likely to die in the >: latter.  Simple enuff?  >For chrissakes, take out your calculator and work out the numbers. >Here... I've preformatted them for you to make it easier:  >\t\t\thandgun homicides/population >\t\t\t---------------------------- >\tSwitzerland :\t24 /  6,350,000 >\t         UK :    8 / 55,670,000  >... and then tell me again how Switzerland is safer with a more >liberal handgun law than the UK is without...by RATE or TOTAL NUMBER. >Your choice. >--  >Stephen Manes\t\t\t\t\t   manes@magpie.linknet.com >Manes and Associates\t\t\t\t   New York, NY, USA  =o&>o  I don't think you can get an accurate indicator of how sa";
        MyReader myReader = ReaderFactory.getReader(filePath);
        HashMap hm = myReader.countWords(filePath);
        System.out.println(hm.size());


//        DataProcess reader = new DataProcess();
//        String pdfPath = "test.pdf";
//        String pdfContent = reader.readPDF(pdfPath);
        //reader.voidWordsBuilder();
    }
}
class Test2{

}

