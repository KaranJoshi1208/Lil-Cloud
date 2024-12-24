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

public val MyIconPack.`Clear-night`: ImageVector
    get() {
        if (`_clear-night` != null) {
            return `_clear-night`!!
        }
        `_clear-night` = Builder(name = "Clear-night", defaultWidth = 56.0.dp, defaultHeight =
                48.0.dp, viewportWidth = 56.0f, viewportHeight = 48.0f).apply {
            path(fill = SolidColor(Color(0xFFffa500)), stroke = null, strokeLineWidth = 1.4105f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(35.2f, 4.1424f)
                lineToRelative(0.96f, 0.4712f)
                lineToRelative(-0.96f, 0.5497f)
                lineToRelative(-0.56f, 0.9424f)
                lineToRelative(-0.48f, -0.9424f)
                lineToRelative(-0.96f, -0.5497f)
                lineToRelative(0.96f, -0.4712f)
                lineToRelative(0.48f, -0.9424f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffa500)), stroke = null, strokeLineWidth = 1.4105f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(51.2f, 11.9958f)
                lineToRelative(0.96f, 0.4712f)
                lineToRelative(-0.96f, 0.5497f)
                lineToRelative(-0.56f, 0.9424f)
                lineToRelative(-0.48f, -0.9424f)
                lineToRelative(-0.96f, -0.5497f)
                lineToRelative(0.96f, -0.4712f)
                lineToRelative(0.48f, -0.9424f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffa500)), stroke = SolidColor(Color(0xFFffa500)),
                    strokeLineWidth = 2.5232f, strokeLineCap = Butt, strokeLineJoin = Round,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(43.6f, 12.3885f)
                curveToRelative(0.0f, -2.9058f, 1.6f, -5.4188f, 4.0f, -6.8325f)
                curveToRelative(-1.2f, -0.7068f, -2.56f, -1.0209f, -4.0f, -1.0209f)
                curveToRelative(-4.4f, 0.0f, -8.0f, 3.534f, -8.0f, 7.8534f)
                reflectiveCurveToRelative(3.6f, 7.8534f, 8.0f, 7.8534f)
                curveToRelative(1.44f, 0.0f, 2.8f, -0.3927f, 4.0f, -1.0209f)
                curveToRelative(-2.4f, -1.3351f, -4.0f, -3.9267f, -4.0f, -6.8325f)
                close()
            }
        }
        .build()
        return `_clear-night`!!
    }

private var `_clear-night`: ImageVector? = null
