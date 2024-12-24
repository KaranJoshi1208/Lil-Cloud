package myiconpack

import MyIconPack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.StrokeJoin.Companion.Round
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val MyIconPack.`Rain-and-snow-mix`: ImageVector
    get() {
        if (`_rain-and-snow-mix` != null) {
            return `_rain-and-snow-mix`!!
        }
        `_rain-and-snow-mix` = Builder(name = "Rain-and-snow-mix", defaultWidth = 56.0.dp,
                defaultHeight = 48.0.dp, viewportWidth = 56.0f, viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0xFF57a0ee)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.2f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(43.7f, 22.4f)
                curveToRelative(0.0f, -4.6f, -3.7f, -8.2f, -8.2f, -8.2f)
                curveToRelative(-1.0f, 0.0f, -1.9f, 0.2f, -2.8f, 0.5f)
                curveToRelative(-0.3f, -3.4f, -3.1f, -6.2f, -6.6f, -6.2f)
                curveToRelative(-3.7f, 0.0f, -6.7f, 3.0f, -6.7f, 6.7f)
                curveToRelative(0.0f, 0.8f, 0.2f, 1.6f, 0.4f, 2.3f)
                curveToRelative(-0.3f, -0.1f, -0.7f, -0.1f, -1.0f, -0.1f)
                curveToRelative(-3.7f, 0.0f, -6.7f, 3.0f, -6.7f, 6.7f)
                curveToRelative(0.0f, 3.6f, 2.9f, 6.6f, 6.5f, 6.7f)
                horizontalLineToRelative(17.2f)
                curveToRelative(4.4f, -0.5f, 7.9f, -4.0f, 7.9f, -8.4f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 1.2f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(27.0f, 32.5f)
                lineTo(27.0f, 37.5f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 1.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(28.7678f, 33.2323f)
                lineTo(25.2322f, 36.7678f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 1.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(29.5f, 35.0f)
                lineTo(24.5f, 35.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 1.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(28.7677f, 36.7678f)
                lineTo(25.2322f, 33.2323f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF91c0f8)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.9782f, 33.2482f)
                lineTo(18.589f, 41.1266f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF91c0f8)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(35.0976f, 33.8833f)
                lineTo(33.7085f, 41.7617f)
            }
        }
        .build()
        return `_rain-and-snow-mix`!!
    }

private var `_rain-and-snow-mix`: ImageVector? = null
