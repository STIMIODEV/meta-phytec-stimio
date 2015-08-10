# Copyright (C) 2015 PHYTEC Messtechnik GmbH,
# Author: Stefan Christ <s.christ@phytec.de>

inherit phygittag
inherit buildinfo
require recipes-kernel/linux/linux-yocto.inc
include linux-common.inc

FILESEXTRAPATHS_prepend = "${THISDIR}/${PN}/features:"

GIT_URL = "git://git.phytec.de/${PN}"
SRC_URI = "${GIT_URL};branch=${BRANCH};protocol=git;nocheckout=1"
SRC_URI_append = " \
    file://ipv6.cfg \
    file://systemd.cfg \
    file://resetdriver.cfg \
    ${@bb.utils.contains('DISTRO_FEATURES', 'mtd-tests', 'file://mtd-tests.cfg', '', d)} \
"

PR = "${INC_PR}.0"

# NOTE: PV must be in the format "x.y.z-.*". It cannot begin with a 'v'.
# NOTE: Keep version in filename in sync with commit id!
SRCREV = "f45b10e27adc3294646e4e5ca2ff13c4b423762f"

LINUX_VERSION = "${PV}"
LINUX_VERSION_EXTERNSION = "-${BSP_VERSION}"

COMPATIBLE_MACHINE  =  "phyflex-imx6-1"
COMPATIBLE_MACHINE .= "|phyflex-imx6-2"
COMPATIBLE_MACHINE .= "|phyflex-imx6-3"
COMPATIBLE_MACHINE .= "|phyflex-imx6-4"
COMPATIBLE_MACHINE .= "|phyflex-imx6-5"
COMPATIBLE_MACHINE .= "|phyflex-imx6-6"
COMPATIBLE_MACHINE .= "|phyflex-imx6-7"
COMPATIBLE_MACHINE .= "|phyflex-imx6-8"
COMPATIBLE_MACHINE .= "|phyflex-imx6-9"
COMPATIBLE_MACHINE .= "|phyflex-imx6-10"

COMPATIBLE_MACHINE .= "|phycard-imx6-1"
COMPATIBLE_MACHINE .= "|phycard-imx6-2"

COMPATIBLE_MACHINE .= "|phyboard-alcor-imx6-1"
COMPATIBLE_MACHINE .= "|phyboard-subra-imx6-1"
COMPATIBLE_MACHINE .= "|phyboard-mira-imx6-1"
COMPATIBLE_MACHINE .= "|phyboard-mira-imx6-2"