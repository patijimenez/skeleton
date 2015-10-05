#!/usr/bin/env sh

HOME=$PWD
# ENV=test
# APPLET_URL=http:\\/\\/www.soafirma.economia.gob.mx\\/WSCommerceFiel\\/WSCommerceFielService\\?wsdl
# BASE=www.sistemaemprendedor.gob.mx
# ENV=dev
# APPLET_URL=http:\\/\\/200.77.231.14\\/WSCommerceFiel\\/WSCommerceFielService\\?wsdl
# BASE=172.18.11.114:28080
ENV=prod
APPLET_URL=http:\\/\\/www.soafirma.economia.gob.mx\\/WSCommerceFiel\\/WSCommerceFielService\\?wsdl
BASE=www.sistemaemprendedor.gob.mx


rm -rf build
mkdir build

sed -e "s/TEMPLATE/${BASE}/g" fpyme-front/app/index.html.template > temp.html
cp fpyme-front/app/index.html .
cp temp.html fpyme-front/app/index.html
cp fpyme-front/app/scripts/services/urlService.js .

cp fpyme-front/app/styles/compass_twitter_bootstrap/_variables.scss .
cp fpyme-front/app/styles/compass_twitter_bootstrap/_variables.scss.template fpyme-front/app/styles/compass_twitter_bootstrap/_variables.scss

cp fpyme-front/app/views/participar.html .
cp fpyme-front/app/views/participar.html.template fpyme-front/app/views/participar.html

sed -e "s/APPLET_URL/${APPLET_URL}/g" fpyme-front/app/scripts/services/urlService.js.template > temp.js
cp temp.js fpyme-front/app/scripts/services/urlService.js

cd fpyme-front
grunt build --force
cd dist/scripts
COMPILED_JS=$(ls *.js)
cd ../../dist/styles
COMPILED_CSS=$(ls *.css)
cd ../..

echo $COMPILED_JS $COMPILED_CSS

mv ../_variables.scss app/styles/compass_twitter_bootstrap/_variables.scss
mv ../participar.html app/views/participar.html
mv ../urlService.js app/scripts/services/urlService.js
mv ../index.html app/index.html

cd $HOME
cp fpyme/grails-app/views/layouts/main.gsp .

sed -e "s/TEMPLATE/${BASE}/g" fpyme/grails-app/views/layouts/main.gsp.template > temp1.gsp
sed -e "s/SCRIPT_CSS/${COMPILED_CSS}/g" temp1.gsp > temp2.gsp
sed -e "s/SCRIPT_JS/${COMPILED_JS}/g" temp2.gsp > temp3.gsp

cp temp3.gsp fpyme/grails-app/views/layouts/main.gsp

cd fpyme

grails $ENV war

cd $HOME

cp main.gsp fpyme/grails-app/views/layouts/main.gsp
rm temp1.gsp temp2.gsp temp3.gsp main.gsp temp.html temp.js

rm -rf build
mkdir build
cd build

jar -xf ../fpyme/target/fpyme-0.1.war
cp -r ../fpyme-front/dist/* .

jar cfvm fpyme-0.1.war META-INF/MANIFEST.MF *
cd $HOME
