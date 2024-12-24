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

public val MyIconPack.`Haze-night`: ImageVector
    get() {
        if (`_haze-night` != null) {
            return `_haze-night`!!
        }
        `_haze-night` = Builder(name = "Haze-night", defaultWidth = 56.0.dp, defaultHeight =
                48.0.dp, viewportWidth = 56.0f, viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0xFFffc04a)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(35.2f, 5.2f)
                lineToRelative(-0.56f, 0.96f)
                lineToRelative(-0.48f, -0.96f)
                lineToRelative(-0.96f, -0.56f)
                lineToRelative(0.96f, -0.48f)
                lineToRelative(0.48f, -0.96f)
                lineToRelative(0.56f, 0.96f)
                lineToRelative(0.96f, 0.48f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffc04a)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(51.2f, 13.2f)
                lineToRelative(-0.56f, 0.96f)
                lineToRelative(-0.48f, -0.96f)
                lineToRelative(-0.96f, -0.56f)
                lineToRelative(0.96f, -0.48f)
                lineToRelative(0.48f, -0.96f)
                lineToRelative(0.56f, 0.96f)
                lineToRelative(0.96f, 0.48f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffc04a)), stroke = SolidColor(Color(0xFFffc04a)),
                    strokeLineWidth = 2.0f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(43.6f, 12.56f)
                curveToRelative(0.0f, -2.96f, 1.6f, -5.52f, 4.0f, -6.96f)
                curveToRelative(-1.2f, -0.72f, -2.56f, -1.04f, -4.0f, -1.04f)
                curveToRelative(-4.4f, 0.0f, -8.0f, 3.6f, -8.0f, 8.0f)
                reflectiveCurveToRelative(3.6f, 8.0f, 8.0f, 8.0f)
                curveToRelative(1.44f, 0.0f, 2.8f, -0.4f, 4.0f, -1.04f)
                curveToRelative(-2.4f, -1.36f, -4.0f, -4.0f, -4.0f, -6.96f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFcd9e73)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(7.0f, 18.0f)
                lineTo(43.0f, 18.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFcd9e73)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.0f, 23.0f)
                lineTo(39.0f, 23.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFcd9e73)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.0f, 28.0f)
                lineTo(46.0f, 28.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFcd9e73)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(13.0f, 33.0f)
                lineTo(48.0f, 33.0f)
            }
        }
        .build()
        return `_haze-night`!!
    }

private var `_haze-night`: ImageVector? = null
