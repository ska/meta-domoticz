SUMMARY = "Domoticz is open source and completely free! You only need to invest in hardware."
DESCRIPTION = "Domoticz is a very light weight home automation system \
that lets you monitor and configure miscellaneous devices, including lights, \
switches, various sensors/meters like temperature, rainfall, wind, \
ultraviolet (UV) radiation, electricity usage/production, gas consumption, \
water consumption and many more. Notifications/alerts can be sent to any mobile device."

LICENSE = "GPLv3 & Unknown & LGPLv2.1"
LIC_FILES_CHKSUM = "file://License.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://www/js/ace/LICENSE;md5=794d11c5219c59c9efa2487c2b4066b2 \
                    file://MQTT/LICENSE.txt;md5=62ddc846179e908dc0c8efec4a42ef20 \
"

SRC_URI = "https://github.com/domoticz/domoticz/archive/${PV}.tar.gz"
SRC_URI[md5sum] = "1d5f5572ae43379a6d62023cb8da0e9b"
SRC_URI[sha256sum] = "c053a2161942529f56b748945ec297dcd67f449e68029fc886893a528891ad86"

S = "${WORKDIR}/domoticz-${PV}"
DEPENDS = "curl openssl boost zlib python3"
RDEPENDS_${PN} = " curl python3"
inherit cmake python-dir pkgconfig useradd


# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE  = " -DCMAKE_INSTALL_PREFIX=/home/domoticz"
EXTRA_OECMAKE += " -DCMAKE_BUILD_TYPE=Release -DUSE_OPENSSL_STATIC='NO'"
FILES_${PN} += "/home/domoticz/*"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-u 1200 -d /home/domoticz -r -s /bin/sh -P 'domoticz' -g domoticz domoticz"
GROUPADD_PARAM_${PN} = "-g 880 domoticz"

