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

public val MyIconPack.`Frost-night`: ImageVector
    get() {
        if (`_frost-night` != null) {
            return `_frost-night`!!
        }
        `_frost-night` = Builder(name = "Frost-night", defaultWidth = 56.0.dp, defaultHeight =
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
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(11.0f, 36.0f)
                lineTo(45.0f, 36.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(15.5f, 41.0f)
                lineTo(40.5f, 41.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(22.5f, 46.0f)
                lineTo(33.5f, 46.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF57a0ee)),
                    strokeLineWidth = 2.0f, strokeLineCap = StrokeCap.Companion.Round,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(28.0f, 33.0f)
                lineTo(28.0f, 11.0f)
                moveTo(28.0f, 24.0f)
                lineToRelative(11.0f, -3.67f)
                moveTo(34.0f, 22.0f)
                lineToRelative(2.0f, -4.0f)
                moveTo(34.0f, 22.0f)
                lineToRelative(4.0f, 2.0f)
                moveTo(28.0f, 24.0f)
                lineToRelative(-11.0f, -3.67f)
                moveTo(22.0f, 22.0f)
                lineToRelative(-2.0f, -4.0f)
                moveTo(22.0f, 22.0f)
                lineToRelative(-4.0f, 2.0f)
                moveTo(28.0f, 16.27f)
                lineToRelative(3.01f, -3.02f)
                moveTo(28.0f, 16.27f)
                lineToRelative(-3.01f, -3.02f)
            }
        }
        .build()
        return `_frost-night`!!
    }

private var `_frost-night`: ImageVector? = null
