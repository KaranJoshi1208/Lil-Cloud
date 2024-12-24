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

public val MyIconPack.`Scattered-thunderstorms-night`: ImageVector
    get() {
        if (`_scattered-thunderstorms-night` != null) {
            return `_scattered-thunderstorms-night`!!
        }
        `_scattered-thunderstorms-night` = Builder(name = "Scattered-thunderstorms-night",
                defaultWidth = 56.0.dp, defaultHeight = 48.0.dp, viewportWidth = 56.0f,
                viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0xFFffa500)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(34.64f, 3.2f)
                lineToRelative(0.56f, 0.96f)
                lineToRelative(0.96f, 0.48f)
                lineToRelative(-0.96f, 0.56f)
                lineToRelative(-0.56f, 0.96f)
                lineToRelative(-0.48f, -0.96f)
                lineToRelative(-0.96f, -0.56f)
                lineToRelative(0.96f, -0.48f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffa500)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(50.64f, 11.2f)
                lineToRelative(0.56f, 0.96f)
                lineToRelative(0.96f, 0.48f)
                lineToRelative(-0.96f, 0.56f)
                lineToRelative(-0.56f, 0.96f)
                lineToRelative(-0.48f, -0.96f)
                lineToRelative(-0.96f, -0.56f)
                lineToRelative(0.96f, -0.48f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffa500)), stroke = SolidColor(Color(0xFFffa500)),
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
            path(fill = SolidColor(Color(0xFFffa500)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(25.32f, 34.28f)
                lineToRelative(3.84f, -11.76f)
                lineToRelative(7.44f, 0.0f)
                lineToRelative(-4.92f, 8.64f)
                lineToRelative(4.68f, 0.0f)
                lineToRelative(-10.56f, 12.36f)
                lineToRelative(4.08f, -9.24f)
                close()
            }
        }
        .build()
        return `_scattered-thunderstorms-night`!!
    }

private var `_scattered-thunderstorms-night`: ImageVector? = null
